package com.tasktoys.java8ws.intptr_t.ch3.ex14;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	Color apply(int x, int y, PixelReader reader);
}
