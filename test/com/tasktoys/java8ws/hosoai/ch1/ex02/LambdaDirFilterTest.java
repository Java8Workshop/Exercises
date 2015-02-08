package com.tasktoys.java8ws.hosoai.ch1.ex02;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class LambdaDirFilterTest {

	LambdaDirFilter target;
	@Before
	public void setup() {
		target = new LambdaDirFilter();
	}

	@Test
	public void test() {
		File[] directories = target.getFilteredDirectories(".");
		for(File f: directories){
			System.out.println(f);
		}
		
		directories = target.getFilteredDirectories(".");
		for(File f: directories){
			System.out.println(f);
		}		
	}
}
