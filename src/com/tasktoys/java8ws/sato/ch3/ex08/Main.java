package com.tasktoys.java8ws.sato.ch3.ex08;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import com.tasktoys.java8ws.sato.ch3.ex06.ImageUtil;
import com.tasktoys.java8ws.sato.ch3.ex06.ImageUtil.ColorTransformer;

public class Main {

	public static void main(String[] args) {
		Image img = ImageUtil.getImage("./out/java.jpg");
		Image timg = ImageUtil.transform(img, makeTransform(img, 20, Color.GREEN));
		ImageUtil.outputImage(timg, "./out/tjava3.jpg", "jpeg");
	}
	
	public static ColorTransformer makeTransform(Image img, int thickness, Color color) {
		int w = (int)img.getWidth();
		int h = (int)img.getHeight();
		return (x, y, c) -> {
			if (x < thickness || y < thickness || w - thickness < x || h - thickness < y) {
				return color;
			} else {
				return c;
			}
		};
	}

}
