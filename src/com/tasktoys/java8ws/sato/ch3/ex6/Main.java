package com.tasktoys.java8ws.sato.ch3.ex6;

import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {

	public static void main(String[] args) {
		Image img = ImageUtil.getImage("./out/java.jpg");
		Image timg = transform(img, (c, factor) -> c.deriveColor(0, 1, factor, 1), 1.2);
		ImageUtil.outputImage(timg, "./out/tjava2.jpg", "jpeg");
	}

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}
}
