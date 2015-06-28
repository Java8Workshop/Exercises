package com.tasktoys.java8ws.lagunapresa.ch4.ex01;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.textProperty().bind(textField.textProperty());
    }
}
