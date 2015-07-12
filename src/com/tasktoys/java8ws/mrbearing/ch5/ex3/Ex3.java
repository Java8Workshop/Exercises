package com.tasktoys.java8ws.mrbearing.ch5.ex3;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Ex3 {
	public static TemporalAdjuster next(Predicate<LocalDate> predicate){

		return TemporalAdjusters.ofDateAdjuster(w -> {
			LocalDate result = w;
			do{
				result = result.plusDays(1);
				System.out.println("res"+result+"bool" +predicate.test(result));

			}while(!predicate.test(result));

			return result;
		});
	}


	public static void main(String[] args){
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate workday =today.with(next(w-> w.getDayOfWeek().getValue()<6));
		System.out.println(workday);
	}
}
