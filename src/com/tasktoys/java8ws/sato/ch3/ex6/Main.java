package com.tasktoys.java8ws.sato.ch3.ex6;

import javafx.scene.image.Image;

public class Main {

	public static void main(String[] args) {
		Image img = ImageUtil.getImage("./out/java.jpg");
		Image timg = ImageUtil.transform(img, (c, factor) -> c.deriveColor(0, 1, factor, 1), 1.2);
		ImageUtil.outputImage(timg, "./out/tjava2.jpg", "jpeg");
	}


}
