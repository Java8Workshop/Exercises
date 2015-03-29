package com.tasktoys.java8ws.intptr_t.ch2.ex04;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch2Ex04 {
	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};

		//
		// int配列に対して、Stream.ofをした場合
		//
		Stream<int[]> intAryStream = Stream.of(values);
		System.out.println("type: " + intAryStream);
		String intAryStreamText = intAryStream
				.map(e -> ""+e )
				.collect(Collectors.joining(", ") );
		System.out.println("element is = " + intAryStreamText);
		
		System.out.println();
		
		//
		// intのストリーム
		//
		IntStream intStream = Arrays.stream(values);
		System.out.println("type: " + intStream);
		String intStreamText = intStream
				.mapToObj(e -> ""+e)
				.collect(Collectors.joining(", "));
		System.out.println("element is = " + intStreamText);
	}
	
}