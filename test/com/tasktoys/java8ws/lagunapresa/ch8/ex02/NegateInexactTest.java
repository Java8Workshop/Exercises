package com.tasktoys.java8ws.lagunapresa.ch8.ex02;

import org.junit.Test;

import static org.junit.Assert.fail;

public class NegateInexactTest {
    @Test
    public void test() {
        try {
            Math.negateExact(Integer.MIN_VALUE);
            fail();
        } catch (ArithmeticException e) {
            ;
        }
    }
}
