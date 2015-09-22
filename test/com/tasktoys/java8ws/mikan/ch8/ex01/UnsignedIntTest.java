/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch8.ex01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author mikan
 */
public class UnsignedIntTest {

    private int max = Integer.MAX_VALUE;

    @Test
    public void testAdd_normalInput() {
        assertEquals(0, new UnsignedInt(0).add(0));
        assertEquals(max, new UnsignedInt(max).add(0));
        assertEquals(max, new UnsignedInt(0).add(max));
    }
}
