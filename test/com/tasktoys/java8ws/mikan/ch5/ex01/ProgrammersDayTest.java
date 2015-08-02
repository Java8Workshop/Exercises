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
    public void testYetAnotherCalc1_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.yetAnotherCalc1(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.yetAnotherCalc1(2016)); // leap
    }

    @Test
    public void testYetAnotherCalc2_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.yetAnotherCalc2(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.yetAnotherCalc2(2016)); // leap
    }

    @Test
    public void testCalcByJavaUtilCalendar_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.calcByJavaUtilCalendar(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.calcByJavaUtilCalendar(2016)); // leap
    }
}
