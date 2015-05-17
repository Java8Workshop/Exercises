package com.tasktoys.java8ws.intptr_t.ch3.ex08;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import com.tasktoys.java8ws.intptr_t.ch3.ex05.ColorTransformer;

public class Ch3Ex08 extends Application {
	public static void main(String[] args) throws IOException {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {		
		// 変換元画像読み込み
		String name = Paths.get("out/queen-mary.png").toUri().toString();
		Image inImg = new Image(name);
		
		// 画像変換
		// ボーダーをブラウン色にする。
		Image outImg = transform(inImg, (int x, int y, Color color) -> color, 10, Color.BROWN);
		
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

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y,
						f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	public static Image transform(Image in, ColorTransformer f, int borderWidth, Color borderColor) {
		return transform(in, (int x, int y, Color c) -> {
			if((x < borderWidth) || (x >= (in.getWidth() - borderWidth)) || 
			   (y < borderWidth) || (y >= (in.getHeight() - borderWidth))) {
				return borderColor;
			} else {
				return f.apply(x, y, c);
			}
		});
	}
}
