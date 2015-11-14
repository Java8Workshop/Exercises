/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch3.ex15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author mikan
 */
public class TransformerApp extends Application {

    private static final String IMAGE_URL = "http://www001.upp.so-net.ne.jp/yshibata/myhomepage/images/js8ri.png";

    public static void main(String[] args) {
        TransformerApp.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(IMAGE_URL);
        Image latentImage = LatentImage.from(image).transform(Color::brighter).transform(Color::grayscale).toImage();
        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(latentImage))));
        primaryStage.show();
    }

    @FunctionalInterface
    public interface ColorTransformer {

         Color apply(int x, int y,  Color colorAtXY);
    }
}
