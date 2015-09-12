package com.tasktoys.java8ws.sato.ex6.ex09;

public class Main {

	public static void main(String[] args) {
		
		IntMatrix a = new IntMatrix(2, 3);
		System.out.println(a.set(0, 0, 5).set(1, 1, 20).set(0, 2, 10));

		IntMatrix b = new IntMatrix(3, 2);
		System.out.println(b.set(0, 1, 10));
		System.out.println(a.mlt(b));

	}

}
