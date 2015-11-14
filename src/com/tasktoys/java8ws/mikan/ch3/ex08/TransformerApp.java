/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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

    public static Image transform(Image in, ColorTransformer f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

    public static ColorTransformer createBorder(Image image, int size, Color color) {
        return (x, y, c) -> x < size || x > image.getWidth() - size || y < size || y > image.getHeight() - size ? color : c;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(IMAGE_URL);
        Image image2 = transform(image, createBorder(image, 10, Color.GRAY));
        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
        primaryStage.show();
    }

    @FunctionalInterface
    public interface ColorTransformer {

        Color apply(int x, int y, Color colorAtXY);
    }
}
