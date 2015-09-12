package com.tasktoys.java8ws.intptr_t.ch8.ex02;

public class Ch8Ex02 {
	public static void main(String[] args) {
		int intNegate = Integer.MIN_VALUE;
		long longNegate = Long.MIN_VALUE;

		try {
			Math.negateExact(intNegate);
		} catch(ArithmeticException e) {
			System.out.println(e + " : " + intNegate);
		}

		try {
			Math.negateExact(longNegate);
		} catch(ArithmeticException e) {
			System.out.println(e + " : " + longNegate);
		}
	}
}
