package com.tasktoys.java8ws.hosoai.ch3.ex06;

import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorTransformer extends Application{
	public static void main(String[] args) {
		ColorTransformer app = new ColorTransformer();
		app.launch(args);
	}
	
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

	@Override
	public void start(Stage stage) throws Exception {
		Image inImg = new Image("https://pbs.twimg.com/media/CEDfyQEVEAAkERc.png");
		Image outImg = transform(inImg, (c, T)-> Color.hsb(c.getHue(), c.getSaturation(), c.getBrightness()*T>1.0?1.0:c.getBrightness()*T), 3.5);
		stage.setScene(new Scene(new HBox(new ImageView(outImg))));
		stage.show();
	}
}
