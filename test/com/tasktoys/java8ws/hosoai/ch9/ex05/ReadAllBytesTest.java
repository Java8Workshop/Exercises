package com.tasktoys.java8ws.hosoai.ch9.ex05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tasktoys.java8ws.hosoai.ch9.ex05.ReadAllBytes;

public class ReadAllBytesTest {
	ReadAllBytes target;
	@Before
	public void setUp() throws Exception {
		target = new ReadAllBytes();
	}

	@Test
	public void testAllRead() {
		target.allRead("out/README","out/ex05out.txt");
	}

	@Test
	public void testReverseArray() {
		byte[] bytes = new byte[]{1,2,3,4,5,6,7,8};
		target.reverseArray(bytes);
		assertArrayEquals(bytes, new byte[]{8,7,6,5,4,3,2,1});
		
		bytes = new byte[]{1,2,3,4,5,6,7};
		target.reverseArray(bytes);
		assertArrayEquals(bytes, new byte[]{7,6,5,4,3,2,1});
	}
}
