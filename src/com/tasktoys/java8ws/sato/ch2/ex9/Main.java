package com.tasktoys.java8ws.sato.ch2.ex9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> ls1 = toList("a", "b", "c", "d");
		ArrayList<String> ls2 = toList("1", "2", "3");
		ArrayList<String> ls3 = toList("HO", "GE", "HO", "GE");
		List<ArrayList<String>> lists = Arrays.asList(ls1, ls2, ls3);
		reduce1(lists.stream()).forEach(System.out::print);
		System.out.println("");
		reduce3(lists.stream()).forEach(System.out::print);
		System.out.println("");
		reduce2(lists.stream()).forEach(System.out::print);
	}
	
	@SafeVarargs
	public static <T> ArrayList<T> toList(T... args) {
		ArrayList<T> ls = new ArrayList<>();
		for (T arg : args) {
			ls.add(arg);
		}
		return ls;
	}

	public static <T> ArrayList<T> reduce1(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<T>(), (ls1, ls2) -> {
			ls1.addAll(ls2);
			return ls1;
		});
	}
	
	public static <T> ArrayList<T> reduce2(Stream<ArrayList<T>> stream) {
		Optional<ArrayList<T>> op = stream.reduce((ls1, ls2) -> {
			ls1.addAll(ls2);
			return ls1;
			});
		return op.orElse(new ArrayList<T>());
	}
	
	public static <T> ArrayList<T> reduce3(Stream<ArrayList<T>> stream) {
		BiFunction<ArrayList<T>, ArrayList<T>, ArrayList<T>> bf = (acc, ls) -> {
			acc.addAll(ls);
			return acc;
		};
		BinaryOperator<ArrayList<T>> bo = (ls1, ls2) -> {
			ls1.addAll(ls2);
			return ls1;
		};
		return stream.reduce(new ArrayList<T>(), bf, bo);
	}
}
