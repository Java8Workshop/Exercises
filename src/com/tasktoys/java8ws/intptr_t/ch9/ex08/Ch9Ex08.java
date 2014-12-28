package com.tasktoys.java8ws.intptr_t.ch9.ex08;

class Point
{
	private int x, y;
	
	public Point(int ax, int ay) {
		x = ax;
		y = ay;
	}
	
	public int compareTo(Point other) {
		if(x < other.x) {
			return -1;
		}
		if (x > other.x) {
			return 1;
		}
		
		if(y < other.y) {
			return -1;
		}
		if(y > other.y) {
			return 1;
		}
		return 0;
	}
}

public class Ch9Ex08 {
	public static void main(String[] args) {
		Point[] pts = new Point[]{
			 new Point(Integer.MIN_VALUE, Integer.MIN_VALUE)
			,new Point(Integer.MAX_VALUE, Integer.MIN_VALUE)
			,new Point(Integer.MIN_VALUE, Integer.MAX_VALUE)
			,new Point(Integer.MAX_VALUE, Integer.MAX_VALUE)
		};
		
		for(Point pt1 : pts) {
			for(Point pt2 : pts) {
				System.out.println(pt1.compareTo(pt2));
			}
			System.out.println();
		}
	}	
}
