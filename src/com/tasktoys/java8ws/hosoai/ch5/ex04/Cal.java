package com.tasktoys.java8ws.hosoai.ch5.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class Cal {
	
	public static void main(String[] args) {
		LocalDate date= null;
		try{
			date = LocalDate.of(Integer.parseInt(args[1]), Integer.parseInt(args[0]), 1);
		}catch(Exception e){
			date = LocalDate.now().withDayOfMonth(1);
		}
		System.out.print(paddingRight("", (date.getDayOfWeek().getValue()-1)*4));
		
		while(date.getDayOfMonth() < 31){
			if(date.getDayOfWeek()==DayOfWeek.SUNDAY){
				System.err.print(paddingRight(""+date.getDayOfMonth(), 4));								
				System.out.println();
			}else{
				System.out.print(paddingRight(""+date.getDayOfMonth(), 4));				
			}			
			date = date.plusDays(1);
		}
	}
	public static String paddingRight(String str, int num){
		return String.format("%1$" + num + "s", str);
	}
}
