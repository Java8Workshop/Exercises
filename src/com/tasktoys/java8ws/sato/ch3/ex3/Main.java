package com.tasktoys.java8ws.sato.ch3.ex3;

import java.util.function.BooleanSupplier;

public class Main {

	public static void main(String[] args) {
		System.out.println("test1");
		assertion(() -> 2 == 2, "error at test1");
		System.out.println("test2");
		assertion(() -> 1 == 2, "error at test2");
		System.out.println("test3");
		assertion(() -> 2 == 2);
	}
	
	public static void assertion(BooleanSupplier s, String... message) {
		if (s.getAsBoolean()) {
			;
		} else {
			for (String str : message) {
				System.err.println(str);
			}
			System.exit(-1);			
		}
	}

}
