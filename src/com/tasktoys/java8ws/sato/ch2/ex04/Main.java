package com.tasktoys.java8ws.sato.ch2.ex04;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		int[] values = new int[] { 1, 4, 9, 16 };
		
		System.out.println(Stream.of(values));
		
		System.out.println("stream of");
		Stream.of(values).forEach(v -> {
			for (int i = 0 ; i < v.length; i++) {
				System.out.print(v[i] + " ");
				}
			});
		System.out.println("\n");
		
		System.out.println("arrays as list");
		Arrays.asList(values).stream().forEach(v -> {
			for (int i = 0 ; i < v.length; i++) {
				System.out.print(v[i] + " ");
				}
			});
		System.out.println("\n");
		
		System.out.println("arrays stream");
		Arrays.stream(values).forEach(v -> System.out.print(v + " "));
	}

}
