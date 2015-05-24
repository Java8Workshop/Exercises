package com.tasktoys.java8ws.mrbearing.ch3.ex06;

import java.nio.IntBuffer;
import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Transformer extends Application {

	private static Image image;
	private static Image image2;

	public static void main(String[] args) {
		// System.out.println("hello");

		image = new Image(
				"https://pbs.twimg.com/media/CEDfyQEVEAAkERc.png");
		 image2= transform(image, (Color c, Boolean b) -> Color.RED,
				new Boolean(false));
		Transformer.launch();

	}

	public static <U> Image transform(Image in, BiFunction<Color, U ,Color> f, U arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getWidth();

		WritableImage out = new WritableImage(width, height);
		//Image returnImage;
		for(int y=0; y < in.getHeight();y++){
			for(int x = 0; x < in.getWidth(); x++){
				PixelReader reader= in.getPixelReader();
				Color c = f.apply(reader.getColor(x, y),arg);
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.setScene(new Scene(new HBox(new ImageView(image2))));
		arg0.show();
	}

}
