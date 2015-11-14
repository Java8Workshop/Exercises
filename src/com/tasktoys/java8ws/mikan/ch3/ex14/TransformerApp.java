/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

/**
 * @author mikan
 */
public class TransformerApp extends Application {

    private static final String IMAGE_URL = "http://www001.upp.so-net.ne.jp/yshibata/myhomepage/images/js8ri.png";

    public static void main(String[] args) {
        TransformerApp.launch();
    }

    public static ColorTransformer createColorTransformer(UnaryOperator<Color> f) {
        return (x, y, c) -> f.apply(c.getColor(x, y));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(IMAGE_URL);
        int width = (int) image.getWidth() - 1;
        Image blur = LatentImage.from(image).transform(TransformerGenerator.createBlur(20)).toImage();
        Image edge = LatentImage.from(image).transform(TransformerGenerator.createEdgeDetection()).toImage();
        Image mirror = LatentImage.from(image).transform((x, y, reader) -> reader.getColor(width - x, y).grayscale()).toImage();
        primaryStage.setScene(new Scene(new VBox(
                new HBox(new ImageView(image), new ImageView(mirror)),
                new HBox(new ImageView(blur), new ImageView(edge)))));
        primaryStage.show();
    }

    @FunctionalInterface
    public interface ColorTransformer {

        Color apply(int x, int y, PixelReader reader);
    }
}
