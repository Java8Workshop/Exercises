package com.tasktoys.java8ws.lagunapresa.ch9.ex10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ComparableLabeledPointTest {

	private static final ComparableLabeledPoint BASE = new ComparableLabeledPoint("name", 0, 0);

	@Test
	public void test() {
		assertThat(BASE.compareTo(new ComparableLabeledPoint("name", 0, 0)) == 0, is(true));
		assertThat(BASE.compareTo(new ComparableLabeledPoint("zame", 0, 0)) < 0, is(true));
		assertThat(BASE.compareTo(new ComparableLabeledPoint("name", 1, 0)) < 0, is(true));
		assertThat(BASE.compareTo(new ComparableLabeledPoint("name", 0, 1)) < 0, is(true));
	}

}
