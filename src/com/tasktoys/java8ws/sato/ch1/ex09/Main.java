package com.tasktoys.java8ws.sato.ch1.ex09;

public class Main {

	public static void main(String[] args) {
		ArrayList2<Integer> col = new ArrayList2<>(1,2,3,4);
		col.forEachIf(i -> System.out.println(i + " is odd"), i -> i % 2 == 1);
	}
}
