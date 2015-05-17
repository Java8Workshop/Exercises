package com.tasktoys.java8ws.intptr_t.ch3.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import com.tasktoys.java8ws.intptr_t.ch3.ex05.ColorTransformer;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
	private Image in;
	private List<ColorTransformer> pendingOperations;
	
	/**
	 * コンストラクタ
	 * @param in 画像
	 */
	private LatentImage(Image in) {
		this.in = in;
		this.pendingOperations = new ArrayList<>();
	}
	
	/**
	 * LatentImageインスタンス生成
	 * @param in 画像
	 * @return 自インスタンス
	 */
	public static LatentImage from(Image in) {
		return new LatentImage(in);
	}

	/**
	 * Colorの単項演算子の遅延処理
	 * @param f Colorの単項演算子
	 * @return 自インスタンス
	 */
	public LatentImage transform(UnaryOperator<Color> f) {
		this.pendingOperations.add((x, y, c) -> f.apply(c));
		return this;
	}
	
	/**
	 * ColorTransformerの遅延処理
	 * @param f ColorTransformer
	 * @return 自インスタンス
	 */
	public LatentImage transform(ColorTransformer f) {
		this.pendingOperations.add(f);
		return this;
	}
	
	/**
	 * 遅延処理を適用した画像へ変換
	 * @return 適用画像
	 */
	public Image toImage() {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for(ColorTransformer f : this.pendingOperations){
					c = f.apply(x, y, c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}
}
