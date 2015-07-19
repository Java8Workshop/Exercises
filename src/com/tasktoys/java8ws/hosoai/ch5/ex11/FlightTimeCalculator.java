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
				LocalDateTime.of(LocalDate.of(2015, 8, 1), LocalTime.of(15, 10)),
				ZoneId.of("America/Los_Angeles"));
		ZonedDateTime arrivalDateTime = ZonedDateTime.of(
				LocalDateTime.of(LocalDate.of(2015, 8, 2), LocalTime.of(11, 10)),
				ZoneId.of("Europe/Berlin"));
		long flightTimeMinute = calculateArrivalTime(departureDateTime, arrivalDateTime).toMinutes();
		showRoute(departureDateTime, arrivalDateTime, flightTimeMinute, 11*60 );
		
		departureDateTime = ZonedDateTime.of(
				LocalDateTime.of(LocalDate.of(2015, 8, 1), LocalTime.of(23, 40)),
				ZoneId.of("Asia/Tokyo"));
		arrivalDateTime = ZonedDateTime.of(
				LocalDateTime.of(LocalDate.of(2015, 8, 1), LocalTime.of(12, 15)),
				ZoneId.of("US/Hawaii"));
		flightTimeMinute = calculateArrivalTime(departureDateTime, arrivalDateTime).toMinutes();
		showRoute(departureDateTime, arrivalDateTime, flightTimeMinute, 7*60+35);

		departureDateTime = ZonedDateTime.of(
				LocalDateTime.of(LocalDate.of(2015, 8, 1), LocalTime.of(16, 40)),
				ZoneId.of("Asia/Tokyo"));
		arrivalDateTime = ZonedDateTime.of(
				LocalDateTime.of(LocalDate.of(2015, 8, 2), LocalTime.of(6, 15)),
				ZoneId.of("Europe/Luxembourg"));
		flightTimeMinute = calculateArrivalTime(departureDateTime, arrivalDateTime).toMinutes();
		showRoute(departureDateTime, arrivalDateTime, flightTimeMinute, 20*60+35);

	}
	
	public static void showRoute(ZonedDateTime departure, ZonedDateTime arrival, long culcFlightTime, long correctFlightTime){
		System.out.print(departure.getZone()+"(" + departure.getHour() + ":" + departure.getMinute()
				+ ") -- flight time ");
		System.out.print( "(" + culcFlightTime/60+":"+culcFlightTime%60+")") ;
		System.out.println("-->"+arrival.getZone()+"(" + arrival.getHour() + ":" + arrival.getMinute()+ ")  correctFlightTime:"+correctFlightTime/60+correctFlightTime%60);
	}
}
