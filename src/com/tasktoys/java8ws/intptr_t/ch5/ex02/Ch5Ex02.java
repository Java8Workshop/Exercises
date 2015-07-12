package com.tasktoys.java8ws.intptr_t.ch5.ex02;

import java.time.LocalDate;

public class Ch5Ex02 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2000, 2, 29);
		
		LocalDate nextYearDate = date.plusYears(1);
		LocalDate nextLeapDate = date.plusYears(4);
		
		System.out.println(nextYearDate);
		System.out.println(nextLeapDate);

		for(int i = 0; i < 4; i++) {
			date = date.plusYears(1);
		}
		System.out.println(date);
	}
}
