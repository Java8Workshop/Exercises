package com.tasktoys.java8ws.hosoai.ch9.ex08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PointTest {
	Point target;
	@Before
	public void setUp() throws Exception {
		target = new Point(Integer.MIN_VALUE+5, Integer.MIN_VALUE+5);
	}

	@Test
	public void test() {
		assertTrue(target.compareTo(new Point(Integer.MIN_VALUE+5, Integer.MIN_VALUE+5))==0);
		assertTrue(target.compareTo(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE))<0);	// x overflow
		assertTrue(target.compareTo(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE))>0);
		assertTrue(target.compareTo(new Point(Integer.MIN_VALUE+5, Integer.MAX_VALUE))<0);	// y overflow
		assertTrue(target.compareTo(new Point(Integer.MIN_VALUE+5, Integer.MIN_VALUE))>0);
	}
}
