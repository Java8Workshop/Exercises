package com.tasktoys.java8ws.lagunapresa.ch3.ex05;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ImagesApp extends Application {

    private static final int IMAGE_MARGIN = 10;

    private static final class Pair {

        final double cursor;
        final List<ImageView> li;

        static Pair empty() {
            return of(0.0, new LinkedList<>());
        }

        static Pair of(double cursor, List<ImageView> li) {
            return new Pair(cursor, li);
        }

        Pair(double cursor, List<ImageView> li) {
            this.cursor = cursor;
            this.li = li;
        }

    }

    public void start(Stage stage) {
        Rectangle2D display = Screen.getPrimary().getVisualBounds();

        List<ImageView> views = defineImages().stream()
                .map(ImageView::new)
                .reduce(Pair.empty(),
                        (acc, v) -> {
                            v.setX(acc.cursor);
                            List<ImageView> li = new LinkedList<>(acc.li);
                            li.add(v);
                            return Pair.of(acc.cursor + v.getImage().getWidth() + IMAGE_MARGIN, li);
                        },
                        (p1, p2) -> {
                            throw new AssertionError();
                        }
                ).li;

        int wWidth = views.stream().collect(Collectors.summingInt(v -> (int) v.getImage().getWidth() + IMAGE_MARGIN)) - IMAGE_MARGIN;
        int wHeight = views.stream().collect(Collectors.summarizingInt(v -> (int) v.getImage().getHeight())).getMax();
        Group root = new Group(new ArrayList<>(views));
        Scene scene = new Scene(root, wWidth, wHeight);
        stage.setTitle(title());
        stage.setScene(scene);

        stage.show();
    }

    abstract protected String title();

    abstract protected List<Image> defineImages();

}


