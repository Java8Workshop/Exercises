package com.tasktoys.java8ws.sato.ch9.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Point p3 = new Point(1,1);
		Point p4 = new Point(1,2);
		
		assertTrue(p1.compareTo(p2) == p1.compareTo2(p2));
		assertTrue(p1.compareTo(p3) == p1.compareTo2(p3));
		assertTrue(p1.compareTo(p4) == p1.compareTo2(p4));
		assertTrue(p2.compareTo(p1) == p2.compareTo2(p1));
		assertTrue(p2.compareTo(p3) == p2.compareTo2(p3));
		assertTrue(p2.compareTo(p4) == p2.compareTo2(p4));
		assertTrue(p3.compareTo(p1) == p3.compareTo2(p1));
		assertTrue(p3.compareTo(p2) == p3.compareTo2(p2));
		assertTrue(p3.compareTo(p4) == p3.compareTo2(p4));
		assertTrue(p4.compareTo(p1) == p4.compareTo2(p1));
		assertTrue(p4.compareTo(p2) == p4.compareTo2(p2));
		assertTrue(p4.compareTo(p3) == p4.compareTo2(p3));
	}
}
