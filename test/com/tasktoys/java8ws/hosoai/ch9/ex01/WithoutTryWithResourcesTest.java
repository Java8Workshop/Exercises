package com.tasktoys.java8ws.hosoai.ch9.ex01;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class WithoutTryWithResourcesTest {
	WithoutTryWithResources target;
	@Before
	public void setUp() throws Exception {
		target = new WithoutTryWithResources();
	}

	@Test
	public void testValidInandOut() {
		try{
			target.withoutTryWithResources("out/README", "out/output.txt");
		}catch(Exception e){
			fail();
		}
	}

	@Test
	public void testInvalidIn() {
		try{
			target.withoutTryWithResources("", "out/output.txt");
		}catch(Exception e){
			fail();
		}
	}

	@Test
	public void testInvalidOut() {
		try{
			target.withoutTryWithResources("out/README", "");
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInvalidInOut() {
		try{
			target.withoutTryWithResources("", "");
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testValidInandOutJava7() {
		try{
			target.tryWithResources("out/README", "out/output.txt");
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInvalidInJava7() {
		try{
			target.tryWithResources("", "out/output.txt");
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInvalidOutJava7() {
		try{
			target.tryWithResources("out/README", "");
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInvalidInOutJava7() {
		try{
			target.tryWithResources("", "");
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
}
