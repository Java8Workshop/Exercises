package com.tasktoys.java8ws.intptr_t.ch5.ex11;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ch5Ex11 {
	public static void main(String[] args) {
		// 出発時刻
		ZonedDateTime flightFrom = ZonedDateTime.of(
				LocalDate.now(),
				LocalTime.of(14, 5),
				ZoneId.of("Europe/Berlin"));
		// 到着時刻
		ZonedDateTime arrivalDateTime = ZonedDateTime.of(
				LocalDate.now(),
				LocalTime.of(16, 40),
				ZoneId.of("America/Los_Angeles"));

		// 飛行時間を計算
		Duration flightDuration = Duration.between(flightFrom.toInstant(), arrivalDateTime.toInstant());
		LocalTime flightTime = LocalTime.ofSecondOfDay(flightDuration.getSeconds());
		
		System.out.println("Flight time: " + flightTime);
	}
}
