package com.tasktoys.java8ws.intptr_t.ch3.ex06;

import java.nio.file.Paths;
import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ch3Ex06 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {		
		// 変換元画像読み込み
		String name = Paths.get("out/queen-mary.png").toUri().toString();
		Image inImg = new Image(name);
		
		// 画像変換
		Image outImg = transform(inImg,
			(c, factor) -> c.deriveColor(0, 1, factor, 1),	// factor分だけcを明るくする
			1.2);	// ファクター1.2を使用する
		
		// 画像を表示
		ImageView outImgView = new ImageView(outImg);
		ImageView inImgView = new ImageView(inImg);
		BorderPane pane = new BorderPane();
		pane.setLeft(inImgView);
		pane.setRight(outImgView);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {				
				out.getPixelWriter().setColor(x, y,
						f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}
}
