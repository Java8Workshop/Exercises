package com.tasktoys.java8ws.lagunapresa.ch9.ex09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LabeledPointTest {

	private static final LabeledPoint BASE = new LabeledPoint("name", 0, 0);

	@Test
	public void testEquals() {
		assertThat(BASE.equals(new LabeledPoint("name", 0, 0)), is(true));
		assertThat(BASE.equals(new LabeledPoint("なめぇ", 0, 0)), is(false));
		assertThat(BASE.equals(new LabeledPoint("name", 1, 0)), is(false));
		assertThat(BASE.equals(new LabeledPoint("name", 0, 1)), is(false));
	}

	@Test
	public void testHashCode() {
		int baseHash = BASE.hashCode();
		assertThat(baseHash == new LabeledPoint("name", 0, 0).hashCode(), is(true));
		assertThat(baseHash == new LabeledPoint("なめぇ", 0, 0).hashCode(), is(false));
		assertThat(baseHash == new LabeledPoint("name", 1, 0).hashCode(), is(false));
		assertThat(baseHash == new LabeledPoint("name", 0, 1).hashCode(), is(false));
	}

}
