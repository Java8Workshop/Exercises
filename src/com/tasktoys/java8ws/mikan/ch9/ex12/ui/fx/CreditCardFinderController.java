/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex12.ui.fx;

import com.tasktoys.java8ws.mikan.ch9.ex12.CreditCardFinder;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mikan
 */
public class CreditCardFinderController implements Initializable {

    @FXML
    private TextField pathTextField;

    @FXML
    private ListView<String> resultListView;

    @FXML
    private Label statusLabel;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private CheckBox subFolderCheckBox;

    @FXML
    private CheckBox ignoreCaseCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pathTextField.setText(System.getProperty("user.home"));
        updateStatus(false, "Press \"Find\" button.");
    }

    @FXML
    public void handleFindButtonAction() {
        String path = pathTextField.getText();
        boolean findSubFolder = subFolderCheckBox.isSelected();
        boolean ignoreCase = ignoreCaseCheckBox.isSelected();
        Executor executor = Executors.newSingleThreadExecutor();
        Task<Map<String, String>> task = new FinderTask(path, findSubFolder, ignoreCase);
        task.setOnScheduled((e) -> updateStatus(true, "Finding " + path + "..."));
        task.setOnCancelled((e) -> updateStatus(false, "Canceled."));
        task.setOnFailed((e) -> updateStatus(false, "Failed."));
        task.setOnSucceeded((e) -> {
            Map<String, String> result;
            try {
                result = task.get();
            } catch (InterruptedException | ExecutionException ex) {
                updateStatus(false, "Exception caught: " + ex.getMessage());
                return;
            }
            ObservableList<String> listRecords = FXCollections.observableArrayList();
            result.keySet().stream().forEach((file) -> listRecords.add(result.get(file) + " (" + file + ")"));
            resultListView.setItems(listRecords);
            updateStatus(false, "Found " + result.size() + " item(s).");
        });
        executor.execute(task);
    }

    private void updateStatus(boolean intermediate, String message) {
        statusLabel.setText(message);
        progressIndicator.setVisible(intermediate);
        progressIndicator.setProgress(-1.0);
    }

    private static class FinderTask extends Task<Map<String, String>> {

        private final String path;
        private final boolean findSubFolder;
        private final boolean ignoreCase;

        public FinderTask(String path, boolean findSubFolder, boolean ignoreCase) {
            this.path = path;
            this.findSubFolder = findSubFolder;
            this.ignoreCase = ignoreCase;
        }

        @Override
        public Map<String, String> call() throws Exception {
            return new CreditCardFinder().find(path, findSubFolder, ignoreCase);
        }
    }
}
