package com.tasktoys.java8ws.hosoai.ch9.ex03;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MultiExceptionThrowTest {
	MultiExceptionThrow target;
	@Before
	public void setUp() throws Exception {
		target = new MultiExceptionThrow();
	}

	@Test
	public void test() {
		try {
			target.process();
		} catch (IOException e) {
			return;
		}
		fail();
	}
}
