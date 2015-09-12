package com.tasktoys.java8ws.lagunapresa.ch8;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcTest {
    @Test
    public void testPlus() throws Exception {
        assertThat(Calc.plus(Integer.MAX_VALUE, Integer.MAX_VALUE), is((long) Integer.MAX_VALUE + (long) Integer.MAX_VALUE));
    }

    @Test
    public void testMinus() throws Exception {
        assertThat(Calc.minus(0, Integer.MAX_VALUE), is(0L - (long) Integer.MAX_VALUE));
    }

    @Test
    public void testDivide() throws Exception {
        assertThat(Calc.divide(10, 2), is(5L));
    }

    @Test
    public void testCompare() throws Exception {
        assertThat(Calc.compare(0, Integer.MAX_VALUE) < 0, is(true));
        assertThat(Calc.compare(0, 0) == 0, is(true));
        assertThat(Calc.compare(Integer.MAX_VALUE, 0) > 0, is(true));
    }
}