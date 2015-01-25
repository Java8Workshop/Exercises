package com.tasktoys.java8ws.lagunapresa.ch1.ex01;

import java.util.Arrays;

public class SortMethod {

	final String name;

	SortMethod(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		String mainFunc = Thread.currentThread().getName();
		SortMethod[] objs = {
				new SortMethod("c"),
				new SortMethod("b"),
				new SortMethod("e"),
				new SortMethod("a"),
				new SortMethod("d"),
		};
		Arrays.sort(objs, (o1, o2) -> {
			System.out.println(mainFunc.equals(Thread.currentThread().getName()) ? "same threads" : "different threads");
			return o1.name.compareTo(o2.name);
		});

		System.out.println(Arrays.toString(objs));

	}

}
