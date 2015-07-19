package com.tasktoys.java8ws.hosoai.ch5.ex03;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class NextDayPredicator {
	public static TemporalAdjuster next(Predicate<LocalDate> predicate){
		return new TemporalAdjuster() {			
			@Override
			public Temporal adjustInto(Temporal temporal) {
				LocalDate result = (LocalDate)temporal;
				do{
					result = result.plusDays(1);
				}while(!predicate.test(result));
				return result;
			}
		};
	}
	
	public static void main(String[] args) {
		LocalDate adjustedDate = LocalDate.now().with(next(w-> w.getDayOfWeek().getValue() < 6));
		System.out.println(adjustedDate+" : next day of week < 6");
	}
}
