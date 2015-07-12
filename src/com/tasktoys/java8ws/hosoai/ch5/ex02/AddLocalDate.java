package com.tasktoys.java8ws.hosoai.ch5.ex02;

import java.time.LocalDate;

public class AddLocalDate {
	public static void main(String[] args) {
		LocalDate basedate = LocalDate.of(2000, 2, 29);
		System.out.println(basedate.plusYears(1) +" : 2000.2.29 + 1 year");
		System.out.println(basedate.plusYears(4) +" : 2000.2.29 + 4 year");
		System.out.println(basedate.plusYears(1).plusYears(1).plusYears(1).plusYears(1) + ": 2000.2.29 + 1 year x 4");
	}
}
