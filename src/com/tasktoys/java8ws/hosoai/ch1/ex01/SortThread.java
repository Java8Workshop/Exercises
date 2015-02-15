package com.tasktoys.java8ws.hosoai.ch1.ex01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortThread {

	public static void main(String[] args) {
		Integer[] values = {5,4,6,3,2,4,5};
		Arrays.sort(values, 
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
			});

		Arrays.sort(values, (Integer i1,Integer i2)->i1.compareTo(i2));
		Stream.of(values).forEach(System.out::println);
	}
}
