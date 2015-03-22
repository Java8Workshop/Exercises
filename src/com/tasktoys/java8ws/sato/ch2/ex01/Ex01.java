package com.tasktoys.java8ws.sato.ch2.ex01;

import java.util.Arrays;
import java.util.List;

public class Ex01 {

	public static void main(String[] args) {
		long c = parallel(Arrays.asList(new String[] {"a", "aa", "bb", "cccc"}));
		System.out.println(c);
	}

	public static long parallel(List<String> words) {
		return words.parallelStream().filter(s -> {
			System.out.println(Thread.currentThread().getName());
			return s.length() > 12;
		}).count();
	}
	
	public static long nonParallel(List<String> words) {
		long c = 0;
		for(String s: words) {
			if (s.length() > 12) c++;
		}
		return c;
	}
}
