package com.tasktoys.java8ws.lagunapresa.ch2.ex08;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ZipperTest {

    @Test
    public void infinite_finite() {
        assertThat(
            Zipper.zip(Stream.of("a", "b", "c"), Stream.generate(() -> "xxx"))
                .collect(Collectors.toList()),
            is(Arrays.asList("a", "xxx", "b", "xxx", "c", "xxx")));
    }

    @Test
    public void finite_infinite() {
        assertThat(
            Zipper.zip(Stream.generate(() -> "xxx"), Stream.of("a", "b", "c"))
                .collect(Collectors.toList()),
            is(Arrays.asList("xxx", "a", "xxx", "b", "xxx", "c", "xxx")));
    }

    @Test
    public void infinite_infinite() {
        assertThat(
            Zipper.zip(Stream.generate(() -> "x"), Stream.generate(() -> "y"))
                .limit(7)
                .collect(Collectors.toList()),
            is(Arrays.asList("x", "y", "x", "y", "x", "y", "x")));
    }

}