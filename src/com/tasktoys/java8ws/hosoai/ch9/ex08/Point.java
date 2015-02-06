package com.tasktoys.java8ws.hosoai.ch9.ex08;

public class Point {
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(Point other){
		long diff = (long)x - (long)other.x;
		if(diff < Integer.MIN_VALUE){
			// overflow
			return (int)(diff>>32); // ままキャストすると結局フローするので，上位ビットの値だけ取得.
		}else if(diff!=0){
			return (int)diff;
		}
		diff = (long)y-(long)other.y;
		if(diff < Integer.MIN_VALUE){
			// overflow
			return (int)(diff>>32);
		}
		return (int)diff;		
	}
}
