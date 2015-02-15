package com.tasktoys.java8ws.hosoai.ch1.ex06;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class UncheckExceptionTest {
	UncheckException target;
	@Before
	public void setUp() throws Exception {
		target = new UncheckException();
	}

	@Test
	public void test() {
		try{
			target.execute();
		}catch(Exception e){
			fail();
		}
	}
}
