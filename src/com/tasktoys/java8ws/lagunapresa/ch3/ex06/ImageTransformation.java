package com.tasktoys.java8ws.lagunapresa.ch3.ex06;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.BiFunction;

public class ImageTransformation extends Application {
    public static <T> Image transform(
            Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));

            }
        }
        return out;
    }

    public static void main(String[] args) {
        ImageTransformation.launch();
    }

    public void start(Stage stage) {
        Image image = new Image("http://image1-1.tabelog.k-img.com/restaurant/images/Rvw/35709/50x50_square_35709635.jpg");
        Image brightenedImage = ImageTransformation.transform(image,
                (c, factor) -> c.deriveColor(0, 1, factor, 1),
                1.2);
        ImageView brightened = new ImageView(brightenedImage);
        brightened.setX(60.0);
        ImageView view = new ImageView(image);
        Group root = new Group(view, brightened);
        Scene scene = new Scene(root, 110, 50);
        stage.setTitle("->");
        stage.setScene(scene);
        stage.show();
    }

}
