package com.tasktoys.java8ws.mrbearing.ch3.ex11;

import java.util.function.*;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

@FunctionalInterface
interface ColorTransformer {
	Color apply(int x, int y, Color colorAtXY);
}

public class ImageDemo extends Application {
	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y,
						f.apply(in.getPixelReader().getColor(x, y)));
		return out;
	}

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y,
						f.apply(x, y, in.getPixelReader().getColor(x, y)));
		return out;
	}

	public static ColorTransformer compose(ColorTransformer c1,
			ColorTransformer c2) {
		return (x, y, c) -> c2.apply(x, y, c1.apply(x, y, c));
	}

	public static ColorTransformer toColorTransformer(UnaryOperator<Color> op) {
		return (x, y, c) -> op.apply(c);
	}

	public void start(Stage stage) {
		// Image image = new Image("queen-mary.png");
		Image image = new Image(
				"https://pbs.twimg.com/media/CEDfyQEVEAAkERc.png");
		/*
		 * Image brightenedImage = transform(image, Color::brighter);
		 */
		Image image2 = transform(image,
				(x, y, c) -> (x / 10) % 2 == (y / 10) % 2 ? Color.GRAY : c);

		Image imageFramed = transform(image, (x, y, c) -> {
			double h = image.getHeight();
			double w = image.getWidth();
			if (x <= 10 || y <= 10)
				return Color.GRAY;
			if (w - 10 <= x || h - 10 <= y)
				return Color.GRAY;
			return c;
		});

		Image imageBrightenedFramed = transform(image,
				compose(toColorTransformer(Color::brighter), (x, y, c) -> {
					double h = image.getHeight();
					double w = image.getWidth();
					if (x <= 10 || y <= 10)
						return Color.GRAY;
					if (w - 10 <= x || h - 10 <= y)
						return Color.GRAY;
					return c;
				}));

		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(
				imageBrightenedFramed))));
		stage.show();
	}

	public static void main(String[] arg) {
		ImageDemo.launch(arg);
	}

}
