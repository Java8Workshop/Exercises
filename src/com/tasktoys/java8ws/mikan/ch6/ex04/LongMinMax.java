/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
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
        LongAccumulator max = new LongAccumulator(Long::max, Long.MIN_VALUE);
        longs.parallel().forEach(max::accumulate);
        return max.get();
    }

    public long min(LongStream longs) {
        Objects.requireNonNull(longs);
        LongAccumulator max = new LongAccumulator(Long::min, Long.MAX_VALUE);
        longs.parallel().forEach(max::accumulate);
        return max.get();
    }
}
