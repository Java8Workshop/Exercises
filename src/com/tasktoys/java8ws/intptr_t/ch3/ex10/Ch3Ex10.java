package com.tasktoys.java8ws.intptr_t.ch3.ex10;

import java.nio.file.Paths;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ch3Ex10 extends Application {

	public static void main(String[] args) {
		launch(args);		
	}
	
	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y,
						f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		String name = Paths.get("out/queen-mary.png").toUri().toString();
		Image image = new Image(name);
		
		UnaryOperator<Color> op = Color::brighter;
		
		// 以下のような呼び出しはできない。
		// UnaryOperator#composeの戻り値がFunction<V, R>のため
		//Image finaImage = transform(image, op.compose(Color::grayscale));
	}
}
