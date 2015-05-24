package com.tasktoys.java8ws.intptr_t.ch3.ex14;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ch3Ex14 extends Application{
	public static void main(String[] args) {
		launch(args);		
	}
		
	@Override
	public void start(Stage stage) throws Exception {		
		// 変換元画像読み込み
		String name = Paths.get("out/queen-mary.png").toUri().toString();
		Image inImg = new Image(name);
		
		// 画像変換
		Image outImg = LatentImageEx14.from(inImg)
			.transform((x, y, reader) -> reader.getColor(x, y).brighter())
			.transform((x, y, reader) -> reader.getColor(x, y).grayscale())
			.convolution((x, y, reader) -> {
				if( (x <= 0) || (y <= 0) || 
				    (x + 1 >= (int)inImg.getWidth()) || (y + 1 >= (int)inImg.getHeight())){ 
					return reader.getColor(x, y);
				}
				Color c = reader.getColor(x, y);
				Color n = reader.getColor(x, y - 1);
				Color e = reader.getColor(x + 1, y);
				Color s = reader.getColor(x, y + 1);
				Color w = reader.getColor(x - 1, y);
				
				double r = 4 * c.getRed() - n.getRed() - e.getRed() - s.getRed() - w.getRed();
				double g = 4 * c.getGreen() - n.getGreen() - e.getGreen() - s.getGreen() - w.getGreen();
				double b = 4 * c.getBlue() - n.getBlue() - e.getBlue() - s.getBlue() - w.getBlue();
				
				if(r < 0.0){ r = 0.0; }
				if(g < 0.0){ g = 0.0; }
				if(b < 0.0){ b = 0.0; }
				if(r > 1.0){ r = 1.0; }
				if(g > 1.0){ g = 1.0; }
				if(b > 1.0){ b = 1.0; }
				
				return Color.color(r, g, b);
			}).transform((x, y, reader) -> {
				if((x < 10) || (x >= (inImg.getWidth() - 10)) || 
				   (y < 10) || (y >= (inImg.getHeight() - 10))) {
					return Color.GRAY;
				} else {
					return reader.getColor(x, y);
				}
			}).toImage();
				
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
}
