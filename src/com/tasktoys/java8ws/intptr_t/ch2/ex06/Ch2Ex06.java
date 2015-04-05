package com.tasktoys.java8ws.intptr_t.ch2.ex06;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch2Ex06 {
	public static void main(String[] args) {
		List<Character> chars = characterStream("boat").collect(Collectors.toList());
		System.out.println(chars);
	}
	
	public static Stream<Character> characterStream(String s) {
		return Stream
				.iterate(0, i -> i+1)
				.limit(s.length())
				.map(i -> s.charAt(i));
	}
}
