package com.tasktoys.java8ws.lagunapresa.ch2.ex04;

import org.junit.Test;

import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WhatStreamOfTest {

    private static final int[] values = {1, 4, 9, 16};

    @Test
    public void testTypeOfStreamOfArray() throws IOException {
        assertThat(Stream.of(values).getClass().getName(),
                is("java.util.stream.ReferencePipeline$Head"));
    }

    @Test
    public void testTypeOfIntStream() throws IOException {
        assertThat(IntStream.of(values).getClass().getName(),
                is("java.util.stream.IntPipeline$Head"));
    }

}
