package com.tasktoys.java8ws.mrbearing.ch8.ex2;

public class ch8ex02 {




	public static void main(String[] args) {

		Math.negateExact(-1);


		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
			try {
				Math.negateExact(i);
			} catch (ArithmeticException e) {
				System.err.println(i+" is exp num");;
				e.printStackTrace();
			}
		}
	}

}
