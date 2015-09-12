/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch8.ex03;

import static org.junit.Assert.assertEquals;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 *
 * @author mikan
 */
@RunWith(Theories.class)
public class GcdCalculatorTest {

    @DataPoints
    public static InputValue[] values = {
        new InputValue(0, 0, 0),
        new InputValue(12, 18, 6),
        new InputValue(18, 27, 9),
        new InputValue(-12, -18, 6)
    };

    public static class InputValue {

        int a;
        int b;
        int gcd;

        public InputValue(int a, int b, int gcd) {
            this.a = a;
            this.b = b;
            this.gcd = gcd;
        }
    }

    @Theory
    public void testGcdWithPercent(InputValue value) {
        assertEquals(value.gcd, GcdCalculator.gcdWithPercent(value.a, value.b));
    }

    @Theory
    public void testGcdWithFloorMod(InputValue value) {
        assertEquals(value.gcd, GcdCalculator.gcdWithFloorMod(value.a, value.b));
    }

    @Theory
    public void testGcdWithRem(InputValue value) {
        assertEquals(value.gcd, GcdCalculator.gcdWithRem(value.a, value.b));
    }
}
