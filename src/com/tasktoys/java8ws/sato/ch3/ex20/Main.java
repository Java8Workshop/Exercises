package com.tasktoys.java8ws.sato.ch3.ex20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(2,3,4,5);
		map(ls, i -> i + 3).forEach(System.out::println);
	}
	
	public static <T, U> List<U> map(List<T> ls, Function<T, U> f) {
		return ls.stream().map(f).collect(Collectors.toList());
	}

}
