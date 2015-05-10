package com.tasktoys.java8ws.sato.ch3.ex05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {

	public static void main(String[] args) {
		Image img = getImage();
		int w = (int)img.getWidth();
		int h = (int)img.getHeight();
		Image timg = transform(img, (int x, int y, Color c) -> {
			if (x < 10 || y < 10 || w - 10 < x || h - 10 < y) {
				return Color.GRAY;
			} else {
				return c;
			}
		});
		outputImage(imageToBufferedImage(timg));
	}
	
	public static Image getImage() {
		File f = new File("./out/java.jpg");
		Image img = null;
		if (f.exists()) {
			FileInputStream in;
			try {
				in = new FileInputStream(f);
				img = new Image(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			img = new Image("http://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Java_logo_and_wordmark.svg/300px-Java_logo_and_wordmark.svg.png");
		}
		return img;
	}
	
	public static BufferedImage imageToBufferedImage(Image img) {
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
	
	public static int toRGB(Color c) {
		int a = (int)(c.getBrightness() * 255);
		int r = (int)(c.getRed() * 255);
		int g = (int)(c.getGreen() * 255);
		int b = (int)(c.getBlue() * 255);
		return (a<<24) | (r<<16) | (g<<8) | b;
	}
	
	public static void outputImage(BufferedImage img) {
		try {
			ImageOutputStream os = ImageIO.createImageOutputStream(new FileOutputStream(new File("./out/javat.jpg")));
			ImageIO.write(img, "jpeg", os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
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
}
