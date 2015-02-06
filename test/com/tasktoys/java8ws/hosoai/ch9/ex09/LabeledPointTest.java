package com.tasktoys.java8ws.hosoai.ch9.ex09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabeledPointTest {
	LabeledPoint target;
	@Before
	public void setUp() throws Exception {
		target = new LabeledPoint("hoge",1,2);
	}

	@Test
	public void test() {
		assertTrue(target.equals(target));
		assertTrue(target.equals(new LabeledPoint("hoge", 1, 2)));
		assertFalse(target.equals(new LabeledPoint("foo", 1, 2)));
		assertFalse(target.equals(new LabeledPoint("hoge", 2, 2)));
		assertFalse(target.equals(new LabeledPoint("hoge", 1, 1)));
	}
}
