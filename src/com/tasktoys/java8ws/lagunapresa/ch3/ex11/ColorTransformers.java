package com.tasktoys.java8ws.lagunapresa.ch3.ex11;

import com.tasktoys.java8ws.lagunapresa.ch3.ex05.ColorTransformer;
import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

public final class ColorTransformers {

    public static ColorTransformer combine(ColorTransformer t1, ColorTransformer t2) {
        return (x, y, c) -> t2.apply(x, y, t1.apply(x, y, c));
    }

    public static ColorTransformer from(UnaryOperator<Color> f) {
        return (x, y, c) -> f.apply(c);
    }

    private ColorTransformers() {
    }

}
