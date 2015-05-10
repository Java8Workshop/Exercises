package com.tasktoys.java8ws.sato.ch3.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import com.tasktoys.java8ws.sato.ch3.ex06.ImageUtil;
import com.tasktoys.java8ws.sato.ch3.ex06.ImageUtil.ColorTransformer;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class LatentImage {

	private Image img;
	private List<ColorTransformer> pendingOperations;

	public LatentImage(Image img) {
		this.img = img;
		pendingOperations = new ArrayList<ColorTransformer>();
	}
	
	public LatentImage transform(UnaryOperator<Color> f) {
		return transform(ImageUtil.convert(f));
	}
	
	public LatentImage transform(ColorTransformer f) {
		pendingOperations.add(f);
		return this;
	}
	
	public Image toImage() {
		pendingOperations.stream().forEach(f -> img = ImageUtil.transform(img, f));
		return img;
	}
}
