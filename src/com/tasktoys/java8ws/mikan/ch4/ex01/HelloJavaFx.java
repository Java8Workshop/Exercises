/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author mikan
 */
public class HelloJavaFx extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String initialText = "Hello, FX";
        Label label = new Label(initialText);
        label.setFont(new Font("Comic Sans MS", 100));
        TextField textField = new TextField(initialText);
        label.textProperty().bind(textField.textProperty()); // bind label <<< textField
        primaryStage.setScene(new Scene(new VBox(label, textField)));
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }

}
