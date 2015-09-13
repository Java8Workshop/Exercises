package com.tasktoys.java8ws.intptr_t.ch8.ex06;

import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Ch8Ex06 {	
	// (練習問題9-8と同じ感じ)
	final static Comparator<Point2D> cmpPoint2D = new Comparator<Point2D>() {			
		@Override
		public int compare(Point2D o1, Point2D o2) {
			int diff = Double.compare(o1.getX(), o2.getX());
			if(diff != 0) {
				return diff;
			}
			return Double.compare(o1.getY(), o2.getY());
		}
	};
	
	final static Comparator<Rectangle2D> cmpRect2D = new Comparator<Rectangle2D>() {
		@Override
		public int compare(Rectangle2D o1, Rectangle2D o2) {
			// メンバの順番、minX -> minY -> width -> heightで比較する
			int diff = Double.compare(o1.getMinX(), o2.getMinX());
			if(diff != 0) {
				return diff;
			}
			diff = Double.compare(o1.getMinY(), o2.getMinY());
			if(diff != 0) {
				return diff;
			}
			
			diff = Double.compare(o1.getWidth(), o2.getWidth());
			if(diff != 0) {
				return diff;
			}
			return Double.compare(o1.getHeight(), o2.getHeight());
		}
	};
	
	public static void main(String[] args) {
		Point2D[] pts = new Point2D[]{
			 new Point2D(Integer.MIN_VALUE, Integer.MIN_VALUE)
			,new Point2D(Integer.MIN_VALUE, Integer.MAX_VALUE)
			,new Point2D(Integer.MAX_VALUE, Integer.MIN_VALUE)
			,new Point2D(Integer.MAX_VALUE, Integer.MAX_VALUE)
		};

		for(Point2D pt1 : pts) {
			StringBuilder lineTest = new StringBuilder();
			for(Point2D pt2 : pts) {
				lineTest.append( String.format("%3d",cmpPoint2D.compare(pt1, pt2)) );
			}
			System.out.println(lineTest.toString());
		}
		
		System.out.println();
		
		Rectangle2D[] rects = new Rectangle2D[]{
			 new Rectangle2D(-1, -1, 1, 1)
			,new Rectangle2D(-1, -1, 1, 2)
			,new Rectangle2D(-1, -1, 2, 1)
			,new Rectangle2D(-1, -1, 2, 2)
			,new Rectangle2D(-1,  0, 1, 1)
			,new Rectangle2D(-1,  0, 1, 2)
			,new Rectangle2D(-1,  0, 2, 1)
			,new Rectangle2D(-1,  0, 2, 2)
			,new Rectangle2D( 0, -1, 1, 1)
			,new Rectangle2D( 0, -1, 1, 2)
			,new Rectangle2D( 0, -1, 2, 1)
			,new Rectangle2D( 0, -1, 2, 2)
			,new Rectangle2D( 0,  0, 1, 1)
			,new Rectangle2D( 0,  0, 1, 2)
			,new Rectangle2D( 0,  0, 2, 1)
			,new Rectangle2D( 0,  0, 2, 2)
		};
		for(Rectangle2D rect1 : rects) {
			StringBuilder lineTest = new StringBuilder();
			for(Rectangle2D rect2 : rects) {
				lineTest.append( String.format("%3d",cmpRect2D.compare(rect1, rect2)) );
			}
			System.out.println(lineTest.toString());
		}
	}
}
