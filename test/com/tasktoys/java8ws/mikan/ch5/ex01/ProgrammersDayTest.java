/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch5.ex01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mikan
 */
public class ProgrammersDayTest {

    @Test
    public void testYetAnotherCalc_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.yetAnotherCalc(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.yetAnotherCalc(2016)); // leap
    }

    @Test
    public void testCalcByJavaUtilCalendar_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.calcByJavaUtilCalendar(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.calcByJavaUtilCalendar(2016)); // leap
    }
}
