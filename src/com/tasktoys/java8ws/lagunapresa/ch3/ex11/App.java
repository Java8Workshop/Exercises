package com.tasktoys.java8ws.lagunapresa.ch3.ex11;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.List;

import static com.tasktoys.java8ws.lagunapresa.ch0.Misc.List;
import static com.tasktoys.java8ws.lagunapresa.ch3.ex05.ColorTransformation.transform;
import static com.tasktoys.java8ws.lagunapresa.ch3.ex11.ColorTransformers.combine;
import static com.tasktoys.java8ws.lagunapresa.ch3.ex11.ColorTransformers.from;

public class App extends com.tasktoys.java8ws.lagunapresa.ch3.ex05.App {

    private static final String IMAGE_URL = "http://mnewsplus.blog7.mmm.me/imgs/m/mnewsplus/09aa3757.jpg";

    private static final double BRIGHTNESS_FACTOR = 1.5;
    private static final double BORDER_WIDTH = 10.0;

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
        return List(
            image,
            transform(image, combine(
                from(c -> c.deriveColor(0.0, 1.0, BRIGHTNESS_FACTOR, 1.0)),
                (x, y, c) -> onBorder(image, BORDER_WIDTH, x, y) ? Color.GRAY : c
            ))
        );
    }

}
