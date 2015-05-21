package com.tasktoys.java8ws.lagunapresa.ch3.ex05;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    private static final double borderWidth = 10.0;
    private static final Color gray = new Color(0.3, 0.3, 0.3, 1.0);
    private static final String imageUrl = "http://mnewsplus.blog7.mmm.me/imgs/m/mnewsplus/09aa3757.jpg";

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

    public static void main(String[] args) {
        App.launch();
    }

    public void start(Stage stage) {
        Image image = new Image(imageUrl);
        ImageView origin = new ImageView(image);
        ImageView formed = new ImageView(transform(image,
                (x, y, c) -> {
                    double w = image.getWidth(), h = image.getHeight();
                    return (x <= borderWidth || w - borderWidth <= x || y <= borderWidth || h - borderWidth <= y) ? gray : c;
                }
        ));

        int separator = 10;
        origin.setX(0.0);
        origin.setY(0.0);
        formed.setX(image.getWidth() + separator);
        formed.setY(0.0);
        Group root = new Group(origin, formed);
        Scene scene = new Scene(root, separator + image.getWidth() * 2, image.getHeight());
        stage.setTitle("ああ＾〜心がぴょんぴょんするんじゃ＾〜");
        stage.setScene(scene);

        stage.show();
    }

}
