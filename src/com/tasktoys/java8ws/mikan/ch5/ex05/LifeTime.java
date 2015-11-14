/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch5.ex05;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author mikan
 */
public class LifeTime {

    private static final LocalDate DAY_OF_BIRTH = LocalDate.of(1988, 4, 12);
    private static final LocalTime EMPTY_TIME = LocalTime.of(0, 0);

    private LifeTime() {
        // static use only
    }

    public static int calcLifeDates() {
        return (int) Duration.between(LocalDateTime.of(DAY_OF_BIRTH, EMPTY_TIME), LocalDateTime.now()).toDays();
    }
}
