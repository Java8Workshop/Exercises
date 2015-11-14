/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch4.ex09;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author mikan
 */
public class PathAnimationApp extends Application {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final int STAR_SIZE = 12;
    private static final int RADIUS_X = 220;
    private static final int RADIUS_Y = 140;

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle sun = new Circle(STAR_SIZE);
        sun.setFill(Color.RED);
        sun.centerXProperty().bind(Bindings.divide(primaryStage.widthProperty(), 2));
        sun.centerYProperty().bind(Bindings.divide(primaryStage.heightProperty(), 2));
        Circle star = new Circle(STAR_SIZE);
        star.setFill(Color.BLUE);
        star.centerXProperty().bind(Bindings.divide(primaryStage.widthProperty(), 2));
        star.centerYProperty().bind(Bindings.divide(primaryStage.heightProperty(), 2));
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(WIDTH / 2);
        ellipse.setCenterY(HEIGHT / 2);
        ellipse.setRadiusX(RADIUS_X);
        ellipse.setRadiusY(RADIUS_Y);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2000));
        pathTransition.setNode(star);
        pathTransition.setPath(ellipse);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.play();
        primaryStage.setScene(new Scene(new Pane(sun, star), WIDTH, HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
