package com.tasktoys.java8ws.sato.ch3.ex10;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import com.tasktoys.java8ws.sato.ch3.ex06.ImageUtil;

public class Main {

	public static void main(String[] args) {
		Image img = ImageUtil.getImage("./out/java.jpg");
		Image timg = ImageUtil.transform(img, compose(Color::brighter, Color::grayscale));
		ImageUtil.outputImage(timg, "./out/tjava4.jpg", "jpeg");
	}

	public static <T> UnaryOperator<T> compose(UnaryOperator<T> op1, UnaryOperator<T> op2) {
		return (T t) -> op2.apply(op1.apply(t));
	}
}
