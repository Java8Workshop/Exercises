package com.tasktoys.java8ws.sato.ch8.ex01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Check +");
		long p = (long)Math.pow(2, 32) - 1;
		for(long i = 0; i < p; i++) {
			int j = (int)(p / 100);
			if (i + (long)j != i + Integer.toUnsignedLong(j)) {
				System.out.println("+ of " + i + " and " + j + " is broken");
			}
		}
		System.out.println("Check is done");
		
		System.out.println("Check -");
		for(long i = 0; i < p; i++) {
			int j = (int)(p / 100);
			if (i - (long)j != i - Integer.toUnsignedLong(j)) {
				System.out.println("- of " + i + " and " + j + " is broken");
			}
		}
		System.out.println("Check is done");

		System.out.println("Check /");
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			int j = (int)(p / 100);
			if (i / (long)j != i / Integer.toUnsignedLong(j)) {
				System.out.println("+ of " + i + " and " + j + " is broken");
			}
		}
		System.out.println("Check is done");

		System.out.println("Check div");
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			int j = (int)(p / 100);
			if (i / (long)j != Integer.divideUnsigned(i, j)) {
				System.out.println("+ of " + i + " and " + j + " is broken");
			}
		}
		System.out.println("Check is done");
	}
}
