package com.tasktoys.java8ws.hosoai.ch3.ex10;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class UnaryOperatorTest {	
	public void testUnaryOpeartor(){
		Image image = new Image("");
		UnaryOperator<Color> op = Color::brighter;
//		Image finalImage = ColorTransformer.trasnform(image, op.compose(Color::grayscale)); // transform needs biFunction, but UnaryOperator.compose return UnaryFunction
	}
}
