package com.tasktoys.java8ws.intptr_t.ch3.ex13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import com.tasktoys.java8ws.intptr_t.ch3.ex05.ColorTransformer;


public class LatentImageEx13 {
	private Image in;
	private List<List<ColorTransformer>> pendingOperations;	// 
	private List<NeighborhoodFilter4> convolutionFilter;	// 4近傍畳み込みフィルタ
	
	private List<ColorTransformer> lastPendingOperations;	// 操作のための、pendingOperationsの最終要素

	/**
	 * コンストラクタ
	 * @param in
	 */
	protected LatentImageEx13(Image in) {
		this.in = in;
		this.pendingOperations = new ArrayList<>();
		this.convolutionFilter = new ArrayList<>();
		
		this.lastPendingOperations = new ArrayList<>();
		this.pendingOperations.add(this.lastPendingOperations);
	}
	
	/**
	 * LatentImageインスタンス生成
	 * @param in 画像
	 * @return 自インスタンス
	 */
	public static LatentImageEx13 from(Image in) {
		return new LatentImageEx13(in);
	}
	
	/**
	 * Colorの単項演算子の遅延処理
	 * @param f Colorの単項演算子
	 * @return 自インスタンス
	 */
	public LatentImageEx13 transform(UnaryOperator<Color> f) {
		this.lastPendingOperations.add((x, y, c) -> f.apply(c));
		return this;
	}
	
	/**
	 * ColorTransformerの遅延処理
	 * @param f ColorTransformer
	 * @return 自インスタンス
	 */
	public LatentImageEx13 transform(ColorTransformer f) {
		this.lastPendingOperations.add(f);
		return this;
	}
	
	/**
	 * NeighborhoodFilter4の遅延処理
	 * @return
	 */
	public LatentImageEx13 transform(NeighborhoodFilter4 f) {
		this.convolutionFilter.add(f);

		// 前段に依存しない変換処理を新規作成
		this.lastPendingOperations = new ArrayList<>();
		this.pendingOperations.add(this.lastPendingOperations);

		return this;
	}
	
	/**
	 * 遅延処理を適用した画像へ変換
	 * @return 適用画像
	 */
	public Image toImage() {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		List<ColorTransformer> xfers = this.pendingOperations.get(0);
	
		// 1段目処理
		WritableImage out = new WritableImage(width, height);
		for(int i = 0; i < this.pendingOperations.size(); i++) {
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					Color c = in.getPixelReader().getColor(x, y);
					for(ColorTransformer f : xfers){
						c = f.apply(x, y, c);
					}
					out.getPixelWriter().setColor(x, y, c);
				}
			}
		}

		// 2段目以降の処理
		for(int i = 1; i < this.pendingOperations.size(); i++) {
			Image preIn = out;
			
			// 畳み込みフィルタ処理
			NeighborhoodFilter4 filter = this.convolutionFilter.get(i - 1);
			out = new WritableImage(width, height);
			for(int x = 1; x < width - 1; x++) {
				for(int y = 1; y < height - 1; y++) {
					Color c = preIn.getPixelReader().getColor(x, y);
					Color n = preIn.getPixelReader().getColor(x, y - 1);
					Color e = preIn.getPixelReader().getColor(x + 1, y);
					Color s = preIn.getPixelReader().getColor(x, y + 1);
					Color w = preIn.getPixelReader().getColor(x - 1, y);
					c = filter.apply(x, y, c, n, e, s, w);
					out.getPixelWriter().setColor(x, y, c);
				}
			}
			
			preIn = out;
			xfers = this.pendingOperations.get(i);
			out = new WritableImage(width, height);
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					Color c = preIn.getPixelReader().getColor(x, y);
					for(ColorTransformer f : xfers){
						c = f.apply(x, y, c);
					}
					out.getPixelWriter().setColor(x, y, c);
				}
			}
		}		
		return out;
	}	
}
