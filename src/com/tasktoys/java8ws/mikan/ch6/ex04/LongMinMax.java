/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch6.ex04;

import java.util.Objects;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;

/**
 *
 * @author mikan
 */
public class LongMinMax {

    public long max(LongStream longs) {
        Objects.requireNonNull(longs);
        LongAccumulator max = new LongAccumulator(Long::max, 0);
        longs.forEach(v -> max.accumulate(v));
        return max.get();
    }

    public long min(LongStream longs) {
        Objects.requireNonNull(longs);
        LongAccumulator max = new LongAccumulator(Long::min, 0);
        longs.forEach(v -> max.accumulate(v));
        return max.get();
    }
}
