/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch2.ex03;

import org.junit.Test;

import java.io.IOException;

/**
 * @author mikan
 */
public class ParallelCountBenchTest {

    private static final String ALICE = "test/res/ch2/alice30.txt";
    private static final String WAR_AND_PEACE = "test/res/ch2/war_and_peace.txt";
    private static final int LENGTH = 12;

    @Test(expected = IllegalArgumentException.class)
    public void run_IAE() throws IOException {
        ParallelCountBench.run(ALICE, -1);
    }

    @Test(expected = IOException.class)
    public void run_IOE() throws IOException {
        ParallelCountBench.run("", LENGTH);
    }

    @Test
    public void run_aliceInput() throws IOException {
        ParallelCountBench.run(ALICE, LENGTH);
    }

    @Test
    public void run_warAndPeaceInput() throws IOException {
        ParallelCountBench.run(WAR_AND_PEACE, LENGTH);
    }
}
