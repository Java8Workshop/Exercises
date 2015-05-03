package com.tasktoys.java8ws.sato.ch3.ex24;

public class Main {

	public static void main(String[] args) {
		Pair<Integer> ip = new Pair<>(2,3);
		System.out.println(ip.mapFold(i -> new Pair<Integer>(i, i + 1), (a, b) -> a + b));
	}

}
