/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch3.ex12;

import com.tasktoys.java8ws.mikan.ch3.ex12.TransformerApp.ColorTransformer;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author mikan
 */
public class LatentImage2 extends LatentImage {

    private final List<ColorTransformer> pendingOperations;
    
    private LatentImage2(Image in) {
        super(in);
        pendingOperations = new LinkedList<>();
    }

    public static LatentImage2 from(Image in) {
        return new LatentImage2(in);
    }

    @Override
    public LatentImage2 transform(UnaryOperator<Color> f) {
        pendingOperations.add(TransformerApp.createColorTransformer(f));
        return this;
    }

    public LatentImage2 transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    @Override
    public Image toImage() {
        Image in = getImage();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f : pendingOperations) {
                    c = f.apply(x, y, c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }
}
