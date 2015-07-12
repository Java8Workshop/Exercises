package com.tasktoys.java8ws.hosoai.ch5.ex10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ArrivalTimeCalculator {
	public static ZonedDateTime calculateArrivalTime(ZonedDateTime departureTime, ZoneId arrivalZone, Duration flightTime){
		return departureTime.plus(flightTime).withZoneSameInstant(arrivalZone);
	}
	
	public static void main(String[] args) {
//		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println); // show zoneIds
		ZonedDateTime los = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 5)), ZoneId.of("America/Los_Angeles"));
		ZoneId frankfurt = ZoneId.of("Europe/Berlin");
		System.out.println("Los+("+los.getHour()+":"+los.getMinute()+") -- flight time 10:50 --> Frankfurt");
		System.out.println("    "+calculateArrivalTime(los, frankfurt, Duration.ofMinutes(10*60 + 50)));
	}
}
