package com.tasktoys.java8ws.intptr_t.ch3.ex14;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImageEx14 {
	private Image in;
	private List<List<ColorTransformer>> pendingOperations;	// 畳み込みフィルタごとに保持した、遅延操作の配列
	private List<ColorTransformer> 	convolutionFilter;	// 4近傍畳み込みフィルタ
	
	private List<ColorTransformer> lastPendingOperations;	// 操作のための、pendingOperationsの最終要素
	
	/**
	 * コンストラクタ
	 * @param in 画像
	 */
	private LatentImageEx14(Image in) {
		this.in = in;
		this.pendingOperations = new ArrayList<>();
		this.convolutionFilter = new ArrayList<>();
		
		this.lastPendingOperations = new ArrayList<>();
		this.pendingOperations.add(this.lastPendingOperations);
	}
	
	/**
	 * LatentImageEx14インスタンス生成
	 * @param in 画像
	 * @return 自インスタンス
	 */
	public static LatentImageEx14 from(Image in) {
		return new LatentImageEx14(in);
	}
	
	/**
	 * ColorTransformerの遅延処理
	 * @param f ColorTransformer
	 * @return 自インスタンス
	 */
	public LatentImageEx14 transform(ColorTransformer f) {
		this.lastPendingOperations.add(f);
		return this;
	}
	
	public LatentImageEx14 convolution(ColorTransformer f) {
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
		int width = (int)this.in.getWidth();
		int height = (int)this.in.getHeight();
		List<ColorTransformer> xfers = this.pendingOperations.get(0);
	
		// 1段目処理
		WritableImage out = new WritableImage(this.in.getPixelReader(), width, height);
		for(int i = 0; i < this.pendingOperations.size(); i++) {
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					for(ColorTransformer f : xfers){
						Color c = f.apply(x, y, out.getPixelReader());
						out.getPixelWriter().setColor(x, y, c);
					}
				}
			}
		}

		// 2段目以降の処理
		for(int i = 1; i < this.pendingOperations.size(); i++) {
			Image preIn = out;
			
			// 畳み込みフィルタ処理
			ColorTransformer filter = this.convolutionFilter.get(i - 1);
			out = new WritableImage(width, height);
			for(int x = 1; x < width - 1; x++) {
				for(int y = 1; y < height - 1; y++) {
					Color c = filter.apply(x, y, preIn.getPixelReader());
					out.getPixelWriter().setColor(x, y, c);
				}
			}
			
			preIn = out;
			xfers = this.pendingOperations.get(i);
			out = new WritableImage(preIn.getPixelReader(), width, height);
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					for(ColorTransformer f : xfers){
						Color c = f.apply(x, y, preIn.getPixelReader());
						out.getPixelWriter().setColor(x, y, c);
					}
				}
			}
		}

		return out;
	}
}
