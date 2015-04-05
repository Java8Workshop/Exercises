package com.tasktoys.java8ws.hosoai.ch2.ex07;

import java.util.stream.Stream;

public class IsFinite {
	
	public static void main(String[] args) {
		Stream<String> infiniteStream = Stream.generate(()->"infinite!");
		Stream<String> finiteStream = Stream.of("F","I","N","I","T","E");
		System.out.println(IsFinite.isFinite(infiniteStream));
		System.out.println(IsFinite.isFinite(finiteStream));
	}
	
	public static <T> boolean isFinite(Stream<T> stream){
		return stream.spliterator().getExactSizeIfKnown()==-1;
	}	
}
