/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex15;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

/**
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

    /* Original code (Chapter 3 Section 3.7) */
    public static Color[][] parallelTransform(Color[][] in, UnaryOperator<Color> f) {
        int n = Runtime.getRuntime().availableProcessors();
        int height = in.length;
        int width = in[0].length;
        Color[][] out = new Color[height][width];
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                int fromY = i * height / n;
                int toY = (i + 1) * height / n;
                pool.submit(() -> {
                    for (int x = 0; x < width; x++) {
                        for (int y = fromY; y < toY; y++) {
                            out[y][x] = f.apply(in[y][x]);
                        }
                    }
                });
            }
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return out;
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        Objects.requireNonNull(f);
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        final int width = (int) in.getWidth();
        final int height = (int) in.getHeight();

        // Load color array from image.
        Color[][] colors = new Color[height][width];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                colors[i][j] = in.getPixelReader().getColor(j, i);
            }
        }

        // Apply the function.
        for (UnaryOperator<Color> f : pendingOperations) {
            colors = parallelTransform(colors, f);
        }

        // Write applied color array.
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                out.getPixelWriter().setColor(y, x, colors[x][y]);
            }
        }
        return out;
    }

    protected Image getImage() {
        return in;
    }
}
