package com.tasktoys.java8ws.sato.ch9.ex10;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LabeledPointTest {
	
	@Test
	public void test() {
		LabeledPoint p1 = new LabeledPoint("hoge", 1, 1);
		LabeledPoint p2 = new LabeledPoint("hoge", 2, 2);
		LabeledPoint p3 = new LabeledPoint("val", 0, 0);
		LabeledPoint p4 = new LabeledPoint("hoge", 1, 1);
		
		assertTrue(p1.compareTo(p2) == -1);
		assertTrue(p2.compareTo(p1) == 1);
		assertTrue(p3.compareTo(p1) > 0);
		assertTrue(p3.compareTo(p2) > 0);
		assertTrue(p1.compareTo(p4) == 0);
	}
	
}
