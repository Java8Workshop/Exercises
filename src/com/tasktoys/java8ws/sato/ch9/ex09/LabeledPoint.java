package com.tasktoys.java8ws.sato.ch9.ex09;

import java.util.Objects;

public class LabeledPoint {

	private String label;
	private int x;
	private int y;
	
	public LabeledPoint(String label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		else if (this == other) return true;
		else if (!(other instanceof LabeledPoint)) return false;
		else {
			LabeledPoint otherLP = (LabeledPoint) other;
			return Objects.equals(label, otherLP.getLabel()) && x == otherLP.getX() && y == otherLP.getY();
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(label);
	}
}
