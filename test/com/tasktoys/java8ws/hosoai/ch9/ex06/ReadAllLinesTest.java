package com.tasktoys.java8ws.hosoai.ch9.ex06;

import org.junit.Before;
import org.junit.Test;

public class ReadAllLinesTest {
	ReadAllLines target;

	@Before
	public void setUp() throws Exception {
		target = new ReadAllLines();
	}

	@Test
	public void testAllRead() {
		target.allReadLines("README.md","out/ex06out.txt");
	}
}
