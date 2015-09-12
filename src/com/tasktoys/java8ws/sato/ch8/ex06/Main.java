package com.tasktoys.java8ws.sato.ch8.ex06;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Point2D p1 = new Point2D(1, 3);
		Point2D p2 = new Point2D(4, 5);
		Point2D p3 = new Point2D(3, 2);
		Point2D p4 = new Point2D(6, 1);
		Point2D p5 = new Point2D(4, 5);
		Point2D p6 = new Point2D(2, 2);
		Point2D p7 = new Point2D(1, 4);
		Point2D p8 = new Point2D(4, 5);
		Point2D p9 = new Point2D(5, 2);
		
		Point2D[] points = new Point2D[] {p1, p2, p3, p4, p5, p6, p7, p8, p9};
		
		System.out.println("Before sorting");
		Arrays.stream(points).forEach(p -> System.out.println(p));
		
		Arrays.sort(points, Comparator.comparingInt(Point2D::getX).thenComparing(Point2D::getY));
		
		System.out.println("After sorting");
		Arrays.stream(points).forEach(p -> System.out.println(p));
	}

}
