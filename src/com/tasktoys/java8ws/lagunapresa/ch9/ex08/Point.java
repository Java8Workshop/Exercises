package com.tasktoys.java8ws.lagunapresa.ch9.ex08;

public class Point implements Comparable<Point> {

	private final int x;

	private final int y;

	public static Point of(int x, int y) {
		return new Point(x, y);
	}

	private Point(int x, int y) {
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
	public int compareTo(Point o) {
		int diff = Long.valueOf(this.x).compareTo(Long.valueOf(o.x));
		if (diff != 0)
			return diff;
		return Long.valueOf(this.y).compareTo(Long.valueOf(o.y));
	}

}
