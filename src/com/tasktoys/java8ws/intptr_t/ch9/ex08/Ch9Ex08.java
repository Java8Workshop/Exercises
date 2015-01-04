package com.tasktoys.java8ws.intptr_t.ch9.ex08;

class Point {
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
	
	public int compareToOriginal(Point other) {
	    int diff = Integer.compare(this.x, other.x);
	    if (diff != 0) {
	      return diff;
	    }
	    return Integer.compare(this.y, other.y);
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

		System.out.println( "Test           Answer");
		for(Point pt1 : pts) {
			StringBuilder lineTest = new StringBuilder();
			StringBuilder lineAns = new StringBuilder( "   " );
			for(Point pt2 : pts) {
				lineTest.append( String.format("%3d",pt1.compareTo(pt2)) );
				lineAns.append( String.format("%3d", pt1.compareToOriginal(pt2)) );
			}
			System.out.println(lineTest.toString() + lineAns.toString());
		}
	}	
}
