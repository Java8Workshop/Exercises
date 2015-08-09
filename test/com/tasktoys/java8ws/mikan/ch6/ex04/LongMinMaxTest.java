/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch6.ex04;

import java.util.Random;
import java.util.stream.LongStream;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mikan
 */
public class LongMinMaxTest {

    private static final int SOURCE_LENGTH = 1000;
    private static long[] source;

    @BeforeClass
    public static void generateSource() {
        source = new long[SOURCE_LENGTH];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < SOURCE_LENGTH; i++) {
            source[i] = random.nextLong();
        }
        source[0] = Long.MAX_VALUE;
        source[SOURCE_LENGTH - 1] = Long.MIN_VALUE;
    }

    @Test(expected = NullPointerException.class)
    public void testMax_NPE() {
        new LongMinMax().max(null);
    }

    @Test
    public void testMax_normalInput() {
        long max = new LongMinMax().max(LongStream.of(source));
        assertEquals(Long.MAX_VALUE, max);
    }

    @Test(expected = NullPointerException.class)
    public void testMin_NPE() {
        new LongMinMax().min(null);
    }

    @Test
    public void testMin_normalInput() {
        long min = new LongMinMax().min(LongStream.of(source));
        assertEquals(Long.MIN_VALUE, min);
    }
}
