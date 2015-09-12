package com.tasktoys.java8ws.lagunapresa.ch8.ex03;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GcdTest {
    @Test
    public void test() {
        assertThat(Gcd.euclid(13, 4, Gcd.StandardRemain.MOD), is(1));
        assertThat(Gcd.euclid(18, 12, Gcd.StandardRemain.MOD), is(6));
    }
}