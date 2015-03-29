package com.tasktoys.java8ws.hosoai.ch2.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypeofIntArrayStream {
	public static void main(String[] args) {
		int[] values = new int[]{1,4,9,16};
		// default stream
		System.out.println(Stream.of(values).getClass());
		// int stream
		System.out.println(IntStream.of(values).getClass());
	}
}
