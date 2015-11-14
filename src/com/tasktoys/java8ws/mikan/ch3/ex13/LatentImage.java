/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex13;

import com.tasktoys.java8ws.mikan.ch3.ex13.TransformerApp.ColorTransformer;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 *
 * @author mikan
 */
public class LatentImage {

    private final Image in;
    private final List<ColorTransformer> pendingOperations;

    private LatentImage(Image in) {
        this.in = in;
        pendingOperations = new LinkedList<>();
    }

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(TransformerApp.createColorTransformer(f));
        return this;
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        Image in = getImage();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (ColorTransformer f : pendingOperations) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    out.getPixelWriter().setColor(x, y, f.apply(x, y, this));
                }
            }
        }
        return out;
    }

    protected Image getImage() {
        return in;
    }
}
