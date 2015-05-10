package com.tasktoys.java8ws.intptr_t.ch3.ex05;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	Color apply(int x, int y, Color colorAtXY);
}
