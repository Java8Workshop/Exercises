package com.tasktoys.java8ws.sato.ch3.ex12;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import com.tasktoys.java8ws.sato.ch3.ex06.ImageUtil;
import com.tasktoys.java8ws.sato.ch3.ex06.ImageUtil.ColorTransformer;

public class Main {

	public static void main(String[] args) {
		Image img = ImageUtil.getImage("./out/java.jpg");
		int w = (int)img.getWidth();
		int h = (int)img.getHeight();
		ColorTransformer t = (x, y, c) -> {
			if (x < 10 || y < 10 || w - 10 < x || h - 10 < y) {
				return Color.GRAY;
			} else {
				return c;
			}
		};
		Image timg = (new LatentImage(img))
				.transform(Color::grayscale)
				.transform(t)
				.toImage();
		ImageUtil.outputImage(timg, "./out/tjava6.jpg", "jpeg");
	}

}
