/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch5.ex01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * Calculate the programmer's day (256th day of year).
 *
 * @author mikan
 */
public class ProgrammersDay {

    private ProgrammersDay() {
        // static use only
    }

    // calc by plusDays
    public static LocalDate calc(int year) {
        return LocalDate.of(year, Month.JANUARY, 1).plusDays(255);
    }

    // calc without plusDays
    public static LocalDate yetAnotherCalc(int year) {
        LocalDate end = LocalDate.of(year, Month.DECEMBER, 31);
        return end.minusDays((end.isLeapYear() ? 366 : 365) - 256);
    }

    // calc by JUC
    public static LocalDate calcByJavaUtilCalendar(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, 0, 1);
        cal.add(Calendar.DAY_OF_YEAR, 255);
        cal.toInstant();
        return LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }
}
