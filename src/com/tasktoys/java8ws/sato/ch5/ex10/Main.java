package com.tasktoys.java8ws.sato.ch5.ex10;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

	
	public static void main(String[] args) {
		System.out.println(arrivalTime(LocalDate.of(2015,7,19), LocalTime.of(12,00), 10, 30));
	}

	public static ZonedDateTime arrivalTime(LocalDate losDate, LocalTime losTime, int flightHours, int flightMinutes) {
		ZonedDateTime losAngels = ZonedDateTime.of(losDate, losTime, ZoneId.of("America/Los_Angeles"));
		ZonedDateTime frankfurt = ZonedDateTime.of(losDate, losTime, ZoneId.of("Europe/Paris"));
		int losAngelsToGMT = losAngels.getOffset().getTotalSeconds();
		int frankfurtToGMT = frankfurt.getOffset().getTotalSeconds();
		
		int losAngelsToFrankfurt = losAngelsToGMT - frankfurtToGMT;
		int flightSeconds = flightHours * 3600 + flightMinutes * 60;
		int difference = flightSeconds + losAngelsToFrankfurt;
		
		int differentHours = (int)(difference / 3600);
		int differentMinutes = (int)((difference % 3600) / 60);
		
		return frankfurt.plusHours(differentHours).plusMinutes(differentMinutes);
	}
}
