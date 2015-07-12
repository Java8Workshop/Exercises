package com.tasktoys.java8ws.intptr_t.ch5.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Ch5Ex04 {

	static final int CAL_LINE_LENGTH = 21;
	
	public static void main(String[] args) {
		int month, year;
		LocalDate date;
		
		switch(args.length) {
		case 0: // now
			date = LocalDate.now();
			makeCal(date.getYear(), date.getMonth()).forEach(System.out::println);
			break;
		case 1: // year only
			date = LocalDate.now();
			
			for(int i = 1; i <= 12; i++){
				System.out.println("        " + Month.of(i).toString());
				makeCal(date.getYear(), Month.of(1)).forEach(System.out::println);
			}
			break;
		case 2: // month and year
			month = Integer.valueOf(args[0]).intValue();
			year = Integer.valueOf(args[1]).intValue();
			makeCal(year, Month.of(month)).forEach(System.out::println);
			break;
		default:
			break;
		}
	}
	
	static List<String> makeCal(int year, Month month) {
		ArrayList<String> calLines = new ArrayList<>();		
		char[] lineBuffer = new char[CAL_LINE_LENGTH];
		LocalDate date = LocalDate.of(year, month, 1);
		
		for(int j = 0; j < lineBuffer.length; j++){ lineBuffer[j] = ' '; }
		
		// 1日から月の最終日までループをまわす
		for(int i = 1;
			i <= date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
			i++, date = date.plusDays(1))
		{
			String dayNum = String.format("%3d", i);
			for(int j = 0; j < dayNum.length(); j++) {
				lineBuffer[date.getDayOfWeek().ordinal() * 3 + j] = dayNum.charAt(j);
			}
			
			// 日曜日の場合、1週間分のデータを追加する
			if(date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				calLines.add(new String(lineBuffer));
				lineBuffer = new char[lineBuffer.length];
				for(int j = 0; j < lineBuffer.length; j++){ lineBuffer[j] = ' '; }
			}
		}

		// 日曜日で終了していない場合、最終週が追加されていないので追加する
		if(date.getDayOfWeek() != DayOfWeek.SUNDAY) {
			calLines.add(new String(lineBuffer));
		}

		return calLines;
	}
}
