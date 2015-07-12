package com.tasktoys.java8ws.hosoai.ch5.ex11;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class FlightTimeCalculator {
	public static Duration calculateArrivalTime(
			ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
		return Duration.of(departureTime.until(arrivalTime, ChronoUnit.MINUTES), ChronoUnit.MINUTES);
	}

	public static void main(String[] args) {
		// ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		// // show zoneIds
		ZonedDateTime departureDateTime = ZonedDateTime.of(
				LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 50)),
				ZoneId.of("Asia/Tokyo"));
		ZonedDateTime arrivalDateTime = ZonedDateTime.of(
				LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(16, 50)),
				ZoneId.of("America/Los_Angeles"));
		Long flightTimeMinute = calculateArrivalTime(departureDateTime, arrivalDateTime).toMinutes();
		
		System.out.print("Tokyo+(" + departureDateTime.getHour() + ":" + departureDateTime.getMinute()
				+ ") -- flight time ");
		System.out.print( "(" + flightTimeMinute/60+":"+flightTimeMinute%60+")") ;
		System.out.println("--> Los Angeles+(" + arrivalDateTime.getHour() + ":" + arrivalDateTime.getMinute()+ ")");
	}
}
