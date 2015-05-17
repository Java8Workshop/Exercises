package com.tasktoys.java8ws.mrbearing.ch3.ex7;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ComparatorCreator {
	public  static Image transform(Image in, UnaryOperator<Color> f){
		int width = (int) in.getWidth();
		int height = (int) in.getWidth();

		WritableImage out = new WritableImage(width, height);


		return null;

	}


	public static void main(String[] args) {


	}

}
