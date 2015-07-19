/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch5.ex02;

import java.time.LocalDate;

/**
 *
 * @author mikan
 */
public class LeapYears {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2000, 2, 29);
        System.out.println("date1: " + date1);
        LocalDate date2 = date1.plusYears(1);
        System.out.println("date2: " + date2 + " (date1 + 1Y)");
        LocalDate date3 = date1.plusYears(4);
        System.out.println("date3: " + date3 + " (date1 + 4Y)");
        LocalDate date4 = date1.plusYears(1).plusYears(1).plusYears(1).plusYears(1);
        System.out.println("date4: " + date4 + " (date1 + 1Yx4)");
        /*
         Result:
         date1: 2000-02-29
         date2: 2001-02-28 (date1 + 1Y)
         date3: 2004-02-29 (date1 + 4Y)
         date4: 2004-02-28 (date1 + 1Yx4)
         */
    }
}
