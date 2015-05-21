package com.tasktoys.java8ws.lagunapresa.ch3.ex05;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public final class ColorTransformation {

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

    private ColorTransformation() {
    }

}
