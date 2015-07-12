package com.tasktoys.java8ws.sato.ch5.ex3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate day = today.with(next(w -> w.getDayOfWeek().equals(DayOfWeek.MONDAY)));
		System.out.println("next working day " + day);
	}
	
	public static TemporalAdjuster next(Predicate<LocalDate> p) {
		return w -> {
			LocalDate d = (LocalDate) w;
			while (!p.test(d)){
				d = d.plusDays(1);
			}
			return d;
		};
	}

}
