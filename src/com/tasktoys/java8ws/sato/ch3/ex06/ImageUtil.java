package com.tasktoys.java8ws.sato.ch3.ex06;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class ImageUtil {
	
	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
	}
	
	public static ColorTransformer compose(ColorTransformer t1, ColorTransformer t2) {
		return (x, y, c) -> t2.apply(x, y, t1.apply(x, y, c));
	}
	
	public static Image transform(Image in, ColorTransformer f) {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
	
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}
	
	public static <T> Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
	
	public static Image getImage(String path) {
		File f = new File(path);
		Image img = null;
		if (f.exists()) {
			FileInputStream in;
			try {
				in = new FileInputStream(f);
				img = new Image(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	
	private static BufferedImage imageToBufferedImage(Image img) {
		int w = (int)img.getWidth();
		int h = (int)img.getHeight();
		int[] rgb = new int[w * h];
		int i = 0;
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				rgb[i] = toRGB(img.getPixelReader().getColor(x, y));
				i++;
			}
		}
		BufferedImage bimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		bimg.setRGB(0, 0, w, h, rgb, 0, w);
		return bimg;
	}
	
	private static int toRGB(Color c) {
		int a = (int)(c.getBrightness() * 255);
		int r = (int)(c.getRed() * 255);
		int g = (int)(c.getGreen() * 255);
		int b = (int)(c.getBlue() * 255);
		return (a<<24) | (r<<16) | (g<<8) | b;
	}
	
	public static void outputImage(Image img, String path, String format) {
		outputImage(imageToBufferedImage(img), path, format);
	}
	
	public static void outputImage(BufferedImage img, String path, String format) {
		try {
			ImageOutputStream os = ImageIO.createImageOutputStream(new FileOutputStream(new File(path)));
			ImageIO.write(img, format, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
