package com.tasktoys.java8ws.lagunapresa.ch6.ex09;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciTest {

    @Test
    public void test() {
        assertThat(Fibonacci.solve(0), is(0L));
        assertThat(Fibonacci.solve(1), is(1L));
        assertThat(Fibonacci.solve(2), is(1L));
        assertThat(Fibonacci.solve(3), is(2L));
        assertThat(Fibonacci.solve(4), is(3L));
        assertThat(Fibonacci.solve(5), is(5L));
        assertThat(Fibonacci.solve(20), is(6765L));
    }

}
