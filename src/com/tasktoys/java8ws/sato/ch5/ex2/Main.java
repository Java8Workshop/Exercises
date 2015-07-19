package com.tasktoys.java8ws.sato.ch5.ex2;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LocalDate feb29 = LocalDate.of(2000, 2, 29);
		System.out.println(feb29);
		System.out.println("1 year later " + feb29.plusYears(1));
		System.out.println("4 year later " + feb29.plusYears(4));
		System.out.println("4 times 1 year later " + feb29.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
	}

}
