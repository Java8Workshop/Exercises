package com.tasktoys.java8ws.hosoai.ch3.ex06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorTransformerApp extends Application{
	public static void main(String[] args) {
		ColorTransformerApp app = new ColorTransformerApp();
		app.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Image inImg = new Image("https://pbs.twimg.com/media/CEDfyQEVEAAkERc.png");
		Image outImg = ColorTransformer.transform(inImg, (c, T)-> Color.hsb(c.getHue(), c.getSaturation(), c.getBrightness()*T>1.0?1.0:c.getBrightness()*T), 3.5);
		stage.setScene(new Scene(new HBox(new ImageView(outImg))));
		stage.show();
	}
}