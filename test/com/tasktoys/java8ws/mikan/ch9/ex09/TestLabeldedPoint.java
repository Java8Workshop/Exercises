/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex09;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test LabeledPoint.
 *
 * @author mikan
 */
public class TestLabeldedPoint {

    @Test
    public void testEquals() {
        LabeledPoint five = new LabeledPoint(5, 5, "five");
        LabeledPoint five2 = new LabeledPoint(5, 5, "five");
        LabeledPoint three = new LabeledPoint(3, 3, "three");
        assertTrue(five.equals(five2));
        assertTrue(five2.equals(five));
        assertFalse(five.equals(three));
        assertTrue(five.hashCode() == five2.hashCode());
        assertTrue(five.hashCode() != three.hashCode());
    }
}
