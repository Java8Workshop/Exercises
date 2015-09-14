package com.tasktoys.java8ws.intptr_t.ch8.ex07;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ch8Ex07 {
	public static void main(String[] args) {
		
		Integer[] ints = new Integer[]{
			4, 2, null, 1, 5, 6, null
		};
		
		//Arrays.sort(ints, Comparator.comparing(i -> i, Comparator.nullsFirst(Comparator.<Integer>naturalOrder()).reversed()));
		//System.out.println(Arrays.asList(ints));
		Arrays.sort(ints, Comparator.comparing(i -> i, Comparator.nullsFirst(Comparator.<Integer>naturalOrder())));
		List<Integer> list = Arrays.asList(ints);
		Collections.reverse(list);
		System.out.println(list);
	}
}
