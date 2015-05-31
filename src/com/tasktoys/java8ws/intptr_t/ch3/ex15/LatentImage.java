package com.tasktoys.java8ws.intptr_t.ch3.ex15;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;

public class LatentImage {
	private Image in;
	private List<UnaryOperator<Color>> pendingOperations;
	
	/**
	 * コンストラクタ
	 * @param in 画像
	 */
	protected LatentImage(Image in) {
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
				for(UnaryOperator<Color> f : this.pendingOperations){
					c = f.apply(c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}
	
	/**
	 * 遅延処理を適用した画像へ変換。
	 * 各ピクセル間の処理が並列に適用されます。1つのピクセルに対する適用順番は順番が守られます。
	 * @return 適用画像
	 */
	public Image parallelToImage() {
		int n = Runtime.getRuntime().availableProcessors();
		int width = (int)this.in.getWidth();
		int height = (int)this.in.getHeight();
		int pixels[] = new int[height * width];
		WritablePixelFormat<IntBuffer> writablePixelFormat = PixelFormat.getIntArgbInstance();
		
		this.in.getPixelReader().getPixels(0, 0, width, height, writablePixelFormat, pixels, 0, width);
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for(int i = 0; i < n; i++) {
				int fromY = i * height / n;
				int toY = (i + 1) * height / n;
				pool.submit(()->{
					for(int y = fromY; y < toY; y++) {
						this.in.getPixelReader().getPixels(0, y, width, 1, writablePixelFormat, pixels, y * width, 0);
						for(int x = 0; x < width; x++) {
							for(UnaryOperator<Color> f : this.pendingOperations){
								// Int -> Color
								int xy = y * width + x;
								double a = (double)((pixels[xy] >> 24) & 0x000000FF) / 255.0;
								double r = (double)((pixels[xy] >> 16) & 0x000000FF) / 255.0;
								double g = (double)((pixels[xy] >>  8) & 0x000000FF) / 255.0;
								double b = (double)((pixels[xy]      ) & 0x000000FF) / 255.0;
								// apply
								Color c = f.apply(Color.color(r, g, b, a));
								// Color -> Int
								pixels[xy] = 
										((int)(c.getOpacity() * 255) << 24) |
										((int)(c.getRed() * 255) << 16) |
										((int)(c.getGreen() * 255) << 8) |
										((int)(c.getBlue() * 255));
							}
						}
					}				
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		WritableImage out = new WritableImage(width, height);
		PixelWriter writer = out.getPixelWriter();
		writer.setPixels(0, 0, width, height, writablePixelFormat, pixels, 0, width);
		
		return out;
	}
	
	/**
	 * 並列変換処理
	 * @param in 適用色
	 * @param f 操作
	 * @return 適用後画像
	 */
	public static Color[][] parallelTransform(
			Color[][] in, UnaryOperator<Color> f) {
		int n = Runtime.getRuntime().availableProcessors();
		int height = in.length;
		int width = in[0].length;
		Color[][] out = new Color[height][width];
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for(int i = 0; i < n; i++) {
				int fromY = i * height / n;
				int toY = (i + 1) * height / n;
				pool.submit(()->{
					for(int x = 0; x < width; x++) {
						for(int y = fromY; y < toY; y++) {
							out[y][x] = f.apply(in[y][x]);
						}
					}
				});				
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		return out;
	}
}