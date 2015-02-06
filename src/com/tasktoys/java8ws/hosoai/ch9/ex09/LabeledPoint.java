package com.tasktoys.java8ws.hosoai.ch9.ex09;

import java.util.Objects;

public class LabeledPoint {
	private String label;
	private int x;
	private int y;
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public LabeledPoint(String label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		int result = 123;
		result = 31 * result + ((label == null) ? 0 : label.hashCode());
		result = 31 * result + x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		
		if(!(obj instanceof LabeledPoint))
			return false;
		LabeledPoint other = (LabeledPoint)obj;
		
		if(x==other.getX() && y==other.getY() && label.equals(other.getLabel()))
			return true;
		return false;
	}
}
