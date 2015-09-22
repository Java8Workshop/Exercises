/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch2.ex10;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author mikan
 */
public class DoubleAverageTest {

    private static final double delta = 0.01;

    @Test(expected = NullPointerException.class)
    public void testAverage_NPE() {
        DoubleAverage.average(null);
    }

    @Test
    public void testAverage_emptyInput() {
        assertEquals(0, DoubleAverage.average(Stream.empty()), delta);
    }

    @Test
    public void testAverage_manyInput() {
        assertEquals(50, DoubleAverage.average(IntStream.rangeClosed(0, 100).asDoubleStream().boxed()), delta);
    }
}
