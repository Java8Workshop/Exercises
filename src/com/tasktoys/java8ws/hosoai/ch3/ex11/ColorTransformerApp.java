package com.tasktoys.java8ws.hosoai.ch3.ex11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import com.tasktoys.java8ws.hosoai.ch3.ex06.ColorTransformer;

public class ColorTransformerApp extends Application{
	public static void main(String[] args) {
		ColorTransformerApp app = new ColorTransformerApp();
		app.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Image inImg = new Image("https://pbs.twimg.com/media/CEDfyQEVEAAkERc.png");
		ColorTransformer c1 = ColorTransformer.fromUnary(Color::brighter);
		ColorTransformer c2 = (x, y, c) -> x < 10 || x > inImg.getWidth() - 10 || y < 10 || y > inImg.getHeight() - 10 ? Color.GRAY : c;
		ColorTransformer c3 = ColorTransformerComposer.compose(c1, c2);
		Image outImg = ColorTransformer.transform(inImg, c3);
		stage.setScene(new Scene(new HBox(new ImageView(outImg))));
		stage.show();
	}
}