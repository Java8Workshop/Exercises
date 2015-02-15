package com.tasktoys.java8ws.hosoai.ch1.ex09;

import org.junit.Before;
import org.junit.Test;

public class Collection2Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Collection2<String> c2 = new ArrayList2<String>();
		c2.add("Hoge");
		c2.add("Foo");
		c2.add("Bar");
		c2.add("Piyo");
		c2.add("Foge");
		c2.forEachIf(System.out::println, s->s.startsWith("F"));
	}	
}
