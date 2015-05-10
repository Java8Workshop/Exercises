package com.tasktoys.java8ws.intptr_t.ch3.ex11;

import java.nio.file.Paths;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import com.tasktoys.java8ws.intptr_t.ch3.ex05.ColorTransformer;

abstract class ColorTransformerUtil {
	public static ColorTransformer compose(ColorTransformer ct1, ColorTransformer ct2) {
		return (x, y, c) -> {
			return ct2.apply(x, y, ct1.apply(x, y, c));
		};
	}
	
	public static ColorTransformer toColorTransformer(UnaryOperator<Color> op){
		return (x, y, color) -> {
			return op.apply(color);
		};
	}
}

public class Ch3Ex11 extends Application {
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
			ColorTransformerUtil.compose(
				ColorTransformerUtil.toColorTransformer(Color::brighter),
				(x, y, color) -> {
				if((x < 10) || (x >= (inImg.getWidth() - 10)) || 
				   (y < 10) || (y >= (inImg.getHeight() - 10))) {
					return Color.GRAY;
				} else {
					return color;
				}
			})
		);
		
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
}
