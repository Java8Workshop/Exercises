/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Based on Horstmann's <code>BindingDemo3</code>.
 *
 * @author mikan
 */
public class BindingApp extends Application {

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
//        smaller.disableProperty().bind(Bindings.lessThanOrEqual(gauge.widthProperty(), 0));
//        larger.disableProperty().bind(Bindings.greaterThanOrEqual(gauge.widthProperty(), 100));
        smaller.disableProperty().bind(Observer.observe(t -> t.doubleValue() <= 0, gauge.widthProperty()));
        larger.disableProperty().bind(Observer.observe(t -> t.doubleValue() >= 100, gauge.widthProperty()));

        HBox box = new HBox(10);
        box.getChildren().addAll(smaller, pane, larger);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }
}
