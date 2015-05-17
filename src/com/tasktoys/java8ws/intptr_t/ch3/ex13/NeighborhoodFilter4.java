package com.tasktoys.java8ws.intptr_t.ch3.ex13;

import javafx.scene.paint.Color;

/**
 * 4近傍フィルタ関数インターフェイス
 */
@FunctionalInterface
public interface NeighborhoodFilter4 {
	Color apply(int x, int y, Color c, Color north, Color east, Color south, Color west);
}
