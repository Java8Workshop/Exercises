package com.tasktoys.java8ws.sato.ch8.ex06;

public class Point2D {

	private int x;
	private int y;
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
}
