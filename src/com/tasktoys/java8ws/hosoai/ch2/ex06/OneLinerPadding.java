package com.tasktoys.java8ws.hosoai.ch2.ex06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OneLinerPadding {
	public static void main(String[] args) {
		String s = "Test String";
		OneLinerPadding.characterStream(s).forEach(System.out::print);
		System.out.println();
		OneLinerPadding.characterStreamEx(s).forEach(System.out::print);		
	}
	
	public static Stream<Character> characterStream(String s){
		List<Character> result = new ArrayList<>();
		for(char c : s.toCharArray()){
			result.add(c);
		}
		return result.stream();
	}
	
	public static Stream<Character> characterStreamEx(String s){
		return IntStream.range(0, s.length()-1).map(s::charAt).mapToObj(i->(char)i);
	}
}
