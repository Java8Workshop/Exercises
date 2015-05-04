package com.tasktoys.java8ws.sato.ch2.ex8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Integer> first = Arrays.asList(1,2,3,4,5);
		List<Integer> second = Arrays.asList(11,12,13);
		Stream<Integer> stream = zip(first.stream(), second.stream());
		stream.forEach(System.out::println);
	}
	
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		List<T> ls1 = first.collect(Collectors.toList());
		List<T> ls2 = second.collect(Collectors.toList());
		if (ls1.size() < ls2.size()) {
			List<T> ls = new ArrayList<>();
			for (int i = 0; i < ls1.size(); i++) {
				ls.add(ls1.get(i));
				ls.add(ls2.get(i));
			}
			return ls.stream();
		} else {
			List<T> ls = new ArrayList<>();
			for (int i = 0; i < ls2.size(); i++) {
				ls.add(ls1.get(i));
				ls.add(ls2.get(i));
			}
			return ls.stream();
		}
	}

}
