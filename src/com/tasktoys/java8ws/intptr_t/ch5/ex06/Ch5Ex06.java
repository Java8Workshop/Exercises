package com.tasktoys.java8ws.intptr_t.ch5.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch5Ex06 {
	public static void main(String[] args) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// 13日金曜日を算出
		List<LocalDate> fridayOf13th =
			IntStream.rangeClosed(1901, 2000)
				.mapToObj(year -> IntStream.rangeClosed(1, 12)
					.mapToObj(month -> LocalDate.of(year, month,13))
					.filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY))
				.flatMap(s -> s)
				.collect(Collectors.toList());
		
		fridayOf13th.forEach(date -> {
			System.out.println(formatter.format(date));
		});
	}
}
