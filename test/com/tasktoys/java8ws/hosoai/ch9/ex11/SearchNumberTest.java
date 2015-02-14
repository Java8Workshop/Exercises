package com.tasktoys.java8ws.hosoai.ch9.ex11;

import org.junit.Before;
import org.junit.Test;

public class SearchNumberTest {
	SearchNumber target;
	@Before
	public void setUp() throws Exception {
		target = new SearchNumber();
	}

	@Test
	public void test() {
		target.search();
	}
}
