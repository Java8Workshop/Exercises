package com.tasktoys.java8ws.hosoai.ch3.ex06;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	public Color apply(int x, int y, Color colorAtXY);
	
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg){
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x=0; x<width; x++){
			for(int y=0; y<height; y++){
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}
	
	public static Image transform(Image in, UnaryOperator<Color> f){
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x=0; x<width; x++){
			for(int y=0; y<height; y++){
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
	
	public static Image transform(Image in, ColorTransformer c){
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x=0; x<width; x++){
			for(int y=0; y<height; y++){
				out.getPixelWriter().setColor(x, y, c.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
	
	public static ColorTransformer fromUnary(UnaryOperator<Color> u){
		return (x,y,c)->u.apply(c);
	}
}
