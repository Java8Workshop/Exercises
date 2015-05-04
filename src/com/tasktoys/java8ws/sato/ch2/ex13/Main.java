package com.tasktoys.java8ws.sato.ch2.ex13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tasktoys.java8ws.sato.ch2.ex01.Ex01;

public class Main {

	public static void main(String[] args) {
		List<String> words = Ex01.getWords();
		Map<Integer, Long> map = words.stream()
				.filter(s -> s.length() < 12)
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		for (Integer key : map.keySet()) {
			System.out.println("length " + key + " " + map.get(key));
		}
	}

}
