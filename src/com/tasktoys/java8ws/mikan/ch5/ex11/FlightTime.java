/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch5.ex11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class FlightTime {

    private FlightTime() {
        //
    }

    public static Duration flightTime(LocalDateTime departureTime,
            ZoneId departureZone,
            LocalDateTime arrivalTime,
            ZoneId arrivalZone) {
        Objects.requireNonNull(departureTime);
        Objects.requireNonNull(departureZone);
        Objects.requireNonNull(arrivalTime);
        Objects.requireNonNull(arrivalZone);
        return Duration.between(ZonedDateTime.of(departureTime, departureZone),
                ZonedDateTime.of(arrivalTime, arrivalZone));
    }

    /**
     * Create a {@link Duration} with hours and minutes.
     *
     * @param h hours
     * @param m minites
     * @return duration
     * @throws DateTimeParseException if the text cannot be parsed to a duration
     */
    public static Duration createHMDuration(int h, int m) {
        // return Duration.parse("PT" + h + "H" + m + "M");
        return Duration.ofMinutes(h * 60 + m);
    }
}
