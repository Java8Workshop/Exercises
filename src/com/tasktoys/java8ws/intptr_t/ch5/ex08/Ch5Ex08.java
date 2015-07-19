package com.tasktoys.java8ws.intptr_t.ch5.ex08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ch5Ex08 {
	public static void main(String[] args) {
		final LocalDateTime today = LocalDateTime.now();
		
		ZoneId.getAvailableZoneIds().stream()
			.map(zone -> ZonedDateTime.of(today, ZoneId.of(zone)).getOffset())
			.forEach(System.out::println);
	}
}
