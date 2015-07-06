/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex08;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author mikan
 */
public class SwingController implements Initializable {

    @FXML
    JFrameAdapter jframe;

    @FXML
    JMenuItem exitItem;

    @FXML
    JMenuItem aboutItem;

    public static void main(String[] args) throws IOException {
        new SwingController().load();
    }

    public void load() throws IOException {
        FXMLLoader.load(getClass().getResource("swing.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("JFrame built: " + jframe.getTitle());
        exitItem.addActionListener(e -> System.exit(0));
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(jframe, jframe.getTitle()));
    }
}
