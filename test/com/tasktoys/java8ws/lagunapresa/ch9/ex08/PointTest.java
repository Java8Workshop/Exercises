package com.tasktoys.java8ws.lagunapresa.ch9.ex08;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		assertThat(Point.of(1, 2).compareTo(Point.of(3, 4)) < 0, is(true));
		assertThat(Point.of(Integer.MAX_VALUE, 0).compareTo(Point.of(Integer.MIN_VALUE, 0)) > 0, is(true));
		assertThat(Point.of(0, Integer.MAX_VALUE).compareTo(Point.of(0, Integer.MIN_VALUE)) > 0, is(true));
	}

}
