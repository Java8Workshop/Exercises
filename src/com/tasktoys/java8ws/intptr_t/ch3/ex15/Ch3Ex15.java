package com.tasktoys.java8ws.intptr_t.ch3.ex15;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ch3Ex15 extends Application {
	public static void main(String[] args) {
		launch(args);		
	}
	
	@Override
	public void start(Stage stage) throws Exception {		
		// 変換元画像読み込み
		String name = Paths.get("out/queen-mary.png").toUri().toString();
		Image inImg = new Image(name);
		
		// 画像変換
		try {
		Image outImg = LatentImage.from(inImg)
			.transform(Color::brighter).transform(Color::grayscale)
			.parallelToImage();
		
		// 画像を表示
		ImageView outImgView = new ImageView(outImg);
		ImageView inImgView = new ImageView(inImg);
		BorderPane pane = new BorderPane();
		pane.setLeft(inImgView);
		pane.setRight(outImgView);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
