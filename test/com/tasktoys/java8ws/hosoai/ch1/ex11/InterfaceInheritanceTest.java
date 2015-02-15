package com.tasktoys.java8ws.hosoai.ch1.ex11;

import org.junit.Before;
import org.junit.Test;

public class InterfaceInheritanceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.print("IJ:");
		new IJ().f();
		System.out.print("IJd:");
		new IJd().f();
		System.out.print("IJs:");
		new IJs().f();
		System.out.print("IdJ:");
		new IdJ().f();
		System.out.print("IdJd:");
		new IdJd().f();
		System.out.print("IdJs:");
		new IdJs().f();
		System.out.print("IsJ:");
		new IsJ().f();
		System.out.print("IsJd:");
		new IsJd().f();
		
		new SI().f();
		new SId().f();
		new SIs().f();
	}
	
}
