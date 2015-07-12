package com.tasktoys.java8ws.intptr_t.ch5.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Ch5Ex03 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		
		System.out.println(
		    today.with(next(w -> w.getDayOfWeek().getValue() < 6))
		);
	}
	
	public static TemporalAdjuster next(Predicate<LocalDate> pred) {
		return TemporalAdjusters.ofDateAdjuster(w -> {
			LocalDate result = w;
			do {
				result = result.plusDays(1);
			}while(!pred.test(result));
			return result;
		});
	}
}
