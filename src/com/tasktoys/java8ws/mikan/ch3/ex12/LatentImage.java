/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch3.ex12;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

/**
 *
 * @author mikan
 */
public class LatentImage {

    private final Image in;
    private final List<UnaryOperator<Color>> pendingOperations;

    protected LatentImage(Image in) {
        Objects.requireNonNull(in);
        this.in = in;
        pendingOperations = new LinkedList<>();
    }

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        Objects.requireNonNull(in);
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (UnaryOperator<Color> f : pendingOperations) {
                    c = f.apply(c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }

    protected Image getImage() {
        return in;
    }
}
