package com.tasktoys.java8ws.lagunapresa.ch3.ex11;

import com.tasktoys.java8ws.lagunapresa.ch3.ex05.ImagesApp;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

import static com.tasktoys.java8ws.lagunapresa.ch3.ex05.ColorTransformation.transform;

public class App extends ImagesApp {

    private static final double BORDER_WIDTH = 10.0;
    private static final double BRIGHTNESS_FACTOR = 1.5;
    private static final Color GRAY = new Color(0.3, 0.3, 0.3, 1.0);
    private static final String IMAGE_URL = "http://mnewsplus.blog7.mmm.me/imgs/m/mnewsplus/09aa3757.jpg";

    public static void main(String[] args) {
        App.launch();
    }

    @Override
    protected String title() {
        return "ああ＾〜心がぴょんぴょんするんじゃ＾〜";
    }

    @Override
    protected List<Image> defineImages() {
        Image image = new Image(IMAGE_URL);
        return Arrays.asList(image, transform(image,
                ColorTransformers.combine(
                        ColorTransformers.from(c -> c.deriveColor(0.0, 1.0, BRIGHTNESS_FACTOR, 1.0)),
                        (x, y, c) -> {
                            double w = image.getWidth(), h = image.getHeight();
                            return (x <= BORDER_WIDTH || w - BORDER_WIDTH <= x || y <= BORDER_WIDTH || h - BORDER_WIDTH <= y) ? GRAY : c;
                        }
                )
        ));
    }

}
