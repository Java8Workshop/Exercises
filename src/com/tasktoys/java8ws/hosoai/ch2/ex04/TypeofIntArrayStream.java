package com.tasktoys.java8ws.hosoai.ch2.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream.of(values)
 *  -> class java.util.stream.ReferencePipeline$Head
 * IntSream.of(values)
 *  -> class java.util.stream.IntPipeline$Head
 */
public class TypeofIntArrayStream {
	public static void main(String[] args) {
		int[] values = new int[]{1,4,9,16};
		// default stream
		System.out.println(Stream.of(values).getClass());
		// int stream
		System.out.println(IntStream.of(values).getClass());
	}
}
