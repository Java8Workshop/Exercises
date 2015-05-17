package com.tasktoys.java8ws.hosoai.ch3.ex10;

import javafx.scene.image.Image;


public class UnaryOperatorTest {	
	public void testUnaryOpeartor(){
		Image image = new Image("");
//		UnaryOperator op = Color::brighter; // brighter is not UnaryOperator
//		Image finalImage = ColorTransformer.trasnform(image, op.compose(Color::grayscale),0); // transform needs biFunction, but UnaryOperator.compose return UnaryFunction
	}
}
