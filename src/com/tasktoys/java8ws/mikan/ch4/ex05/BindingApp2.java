/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Based on Horstmann's <code>BindingDemo3</code>.
 *
 * @author mikan
 */
public class BindingApp2 extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) {
        Button smaller = new Button("Smaller");
        Button larger = new Button("Larger");
        Rectangle gauge = new Rectangle(0, 5, 50, 15);
        Rectangle outline = new Rectangle(0, 5, 100, 15);
        outline.setFill(null);
        outline.setStroke(Color.BLACK);
        Pane pane = new Pane();
        pane.getChildren().addAll(gauge, outline);
        smaller.setOnAction(event -> gauge.setWidth(gauge.getWidth() - 10));
        larger.setOnAction(event -> gauge.setWidth(gauge.getWidth() + 10));
        TextField minField = new TextField();
        minField.setText("0");
        TextField maxField = new TextField();
        maxField.setText("100");
        smaller.disableProperty().bind(Observer.observe(
                (t, u) -> t.doubleValue() <= str2double(u, larger.getWidth()),
                gauge.widthProperty(), minField.textProperty()));
        larger.disableProperty().bind(Observer.observe(
                (t, u) -> t.doubleValue() >= str2double(u, larger.getWidth()),
                gauge.widthProperty(), maxField.textProperty()));
        outline.widthProperty().bind(Observer.observe(t -> Integer.parseInt(t), maxField.textProperty()));
        VBox box = new VBox(10);
        HBox h1 = new HBox(smaller, pane, larger);
        HBox h2 = new HBox(minField, maxField);
        box.getChildren().addAll(h1, h2);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }

    private static double str2double(String s, double defaultValue) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
