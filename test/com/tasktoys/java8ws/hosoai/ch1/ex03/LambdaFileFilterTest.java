package com.tasktoys.java8ws.hosoai.ch1.ex03;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class LambdaFileFilterTest {
	LambdaFileFilter target;

	@Before
	public void setUp() throws Exception {
		target = new LambdaFileFilter();
	}

	@Test
	public void test() {
		File[] files = target.getFilteredFiles("out", "txt");
		for(File f : files){
			System.out.println(f);
		}
	}
}
