package com.tasktoys.java8ws.lagunapresa.ch2.ex07;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FinitenessCheckerTest {

    @Test
    public void test() {
        assertThat(FinitenessChecker.isFinite(Stream.empty()), is(true));
        assertThat(FinitenessChecker.isFinite(Stream.of(1, 2, 3)), is(true));
        assertThat(FinitenessChecker.isFinite(Stream.iterate(1, x -> x)), is(false));
//        assertThat(FinitenessChecker.isFinite(Stream.iterate(1, x -> x).sorted()), is(true)); // XXX
    }

}
