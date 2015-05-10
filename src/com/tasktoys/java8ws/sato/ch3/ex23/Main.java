package com.tasktoys.java8ws.sato.ch3.ex23;

public class Main {

	public static void main(String[] args) {
		Pair<Integer> ip = new Pair<>(2,3);
		System.out.println(ip.map(i -> i + 1));
	}

}
