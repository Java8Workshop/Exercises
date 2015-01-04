package com.tasktoys.java8ws.sato.ch9.ex08;

public class Point {

	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Point point) {
		if (x == point.getX() && y == point.getY()) return 0;
		else if (x > point.getX()) return 1;
		else if (y > point.getY()) return 1;
		else return -1;
	}
	
	public int compareTo2(Point other) {
		int diff = Integer.compare(x, other.getX());
		if (diff != 0) return diff;
		return Integer.compare(y, other.getY());
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
