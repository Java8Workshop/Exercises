package com.tasktoys.java8ws.hosoai.ch9.ex07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SaveWebPageTest {

	SaveWebPage target;
	@Before
	public void setUp() throws Exception {
		target = new SaveWebPage();
	}

	@Test
	public void test() {
		target.save("http://google.com/index.html", "out/ex07out.txt");
	}
}
