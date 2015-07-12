package com.tasktoys.java8ws.intptr_t.ch5.ex01;

import java.time.LocalDate;

public class Ch5Ex01 {

	static final int stdMonthOfDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static final int year = 2014;
	static final int programmersDayAddValue = 255;
	
	public static void main(String[] args) {
		LocalDate programmersDay;
		
		// plusDaysを使わず、プログラマーの日を計算する
		programmersDay = LocalDate.of(year, 1, 1);
		int days = programmersDay.getDayOfMonth() + programmersDayAddValue;
		int m = 0;
		while(days > stdMonthOfDays[m]) {
			days -= stdMonthOfDays[m];
			m++;
		}
		
		// 閏年の場合、2/29日分(1日)を減算する
		if(programmersDay.isLeapYear() && m > 2) {
			days -= 1;
		}
		
		programmersDay = LocalDate.of(programmersDay.getYear(), m + 1, days);
		
		// 答えを生成
		LocalDate ans = LocalDate.of(year, 1, 1).plusDays(programmersDayAddValue);
		System.out.println(programmersDay + " = " + ans);
	}
}
