package com.tasktoys.java8ws.sato.ch9.ex09;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LabeledPointTest {
	
	@Test
	public void test() {
		Map<LabeledPoint, String> map = new HashMap<>();
		map.put(new LabeledPoint("hoge", 1, 1), "hoge11");
		assertEquals("hoge11", map.get(new LabeledPoint("hoge", 1, 1)));
	}
	
	@Test
	public void test2() {
		assertTrue(new LabeledPoint("hoge", 3, 3).equals(new LabeledPoint("hoge", 3, 3)));
		assertFalse(new LabeledPoint("hoge", 3, 3).equals(new LabeledPoint("hoge", 3, 4)));
	}

}
