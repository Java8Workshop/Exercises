package com.tasktoys.java8ws.sato.ch8.ex14;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<>();
		try {
			show(addTwice(ls, null));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		try {
			show(addTwiceNonNull(ls, null));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void show(List<Integer> ls) {
		ls.forEach(i -> System.out.println(i.doubleValue()));
	}
	
	public static List<Integer> addTwice(List<Integer> ls, Integer i) {
		ls.add(i);
		ls.add(i);
		return ls;
	}
	
	public static List<Integer> addTwiceNonNull(List<Integer> ls, Integer i) {
		Objects.requireNonNull(i);
		ls.add(i);
		ls.add(i);
		return ls;
	}
}