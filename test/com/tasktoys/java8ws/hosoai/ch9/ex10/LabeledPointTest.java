package com.tasktoys.java8ws.hosoai.ch9.ex10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tasktoys.java8ws.hosoai.ch9.ex10.LabeledPoint;

public class LabeledPointTest {
	LabeledPoint target;
	@Before
	public void setUp() throws Exception {
		target = new LabeledPoint("hoge",1,2);
	}

	@Test
	public void test() {
		assertTrue(target.compareTo(target)==0);
		assertTrue(target.compareTo(new LabeledPoint("hoge", 1, 2))==0);
		assertTrue(target.compareTo(new LabeledPoint("hogf", 1, 2))<0);
		assertTrue(target.compareTo(new LabeledPoint("hogd", 1, 2))>0);
		assertTrue(target.compareTo(new LabeledPoint("hoge", 2, 2))<0);
		assertTrue(target.compareTo(new LabeledPoint("hoge", 0, 2))>0);
		assertTrue(target.compareTo(new LabeledPoint("hoge", 1, 3))<0);
		assertTrue(target.compareTo(new LabeledPoint("hoge", 1, 1))>0);
	}
}
