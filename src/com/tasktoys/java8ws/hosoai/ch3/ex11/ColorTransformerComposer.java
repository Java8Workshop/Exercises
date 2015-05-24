package com.tasktoys.java8ws.hosoai.ch3.ex11;

import com.tasktoys.java8ws.hosoai.ch3.ex06.ColorTransformer;

public class ColorTransformerComposer {
	public static ColorTransformer compose(ColorTransformer c1, ColorTransformer c2){
		return (x,y,color)-> c1.apply(x, y, c2.apply(x, y, color));
	}
}
