/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch6.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @author mikan
 */
public class AdderBench {

    public void incrementWithAtomicLong(int threads, int limit) {
        AtomicLong adder = new AtomicLong();
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        Instant begin = Instant.now();
        IntStream.range(0, threads).forEach(i -> executorService.submit(() -> IntStream.range(0, limit)
                .forEach(n -> adder.incrementAndGet())));
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            System.err.println("Interrupted. " + ex.getMessage());
        }
        Instant end = Instant.now();
        System.out.println("AtomicLong: " + Duration.between(begin, end).toMillis() + "msec. Value: " + adder.longValue());
    }

    public void incrementWithLongAdder(int threads, int limit) {
        LongAdder adder = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        Instant begin = Instant.now();
        IntStream.range(0, threads).forEach(i -> executorService.submit(() -> IntStream.range(0, limit)
                .forEach(n -> adder.increment())));
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            System.err.println("Interrupted. " + ex.getMessage());
        }
        Instant end = Instant.now();
        System.out.println("LongAdder:  " + Duration.between(begin, end).toMillis() + "msec. Value: " + adder.longValue());
    }
}
