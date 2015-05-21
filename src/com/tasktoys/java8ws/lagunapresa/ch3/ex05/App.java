package com.tasktoys.java8ws.lagunapresa.ch3.ex05;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

import static com.tasktoys.java8ws.lagunapresa.ch3.ex05.ColorTransformation.transform;

public class App extends ImagesApp {

    private static final String IMAGE_URL = "http://mnewsplus.blog7.mmm.me/imgs/m/mnewsplus/09aa3757.jpg";

    private static final double BORDER_WIDTH = 10.0;
    private static final Color GRAY = new Color(0.3, 0.3, 0.3, 1.0);

    public static void main(String[] args) {
        launch();
    }

    @Override
    protected String title() {
        return "ああ＾〜心がぴょんぴょんするんじゃ＾〜";
    }

    @Override
    protected List<Image> defineImages() {
        Image image = new Image(IMAGE_URL);
        return Arrays.asList(
            image,
            transform(image,
                (x, y, c) -> onBorder(image, BORDER_WIDTH, x, y) ? GRAY : c
            )
        );
    }

    protected final boolean onBorder(Image img, double borderWidth, int x, int y) {
        return (x <= borderWidth || img.getWidth() - borderWidth <= x || y <= borderWidth || img.getHeight() - borderWidth <= y);
    }

}
