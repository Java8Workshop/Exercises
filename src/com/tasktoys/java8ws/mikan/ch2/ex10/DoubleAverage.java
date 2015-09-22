/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch2.ex10;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class DoubleAverage {

    private DoubleAverage() {
        // static use only
    }

    public static double average(Stream<Double> stream) {
        Objects.requireNonNull(stream);
        AtomicLong count = new AtomicLong();
        double sum = stream.peek(d -> count.incrementAndGet()).reduce(0.0, Double::sum); // reduce() is a terminal operation
        return count.get() == 0 ? 0 : sum / count.get();
    }
}
