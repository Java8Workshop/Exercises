package com.tasktoys.java8ws.lagunapresa.ch6.ex04;

import java.util.Optional;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

public class LongExtremaFinder {

    public enum Extrema {
        MAXIMAL(Long.MIN_VALUE, Long::max),
        MINIMAL(Long.MAX_VALUE, Long::min);

        private final long identity;
        private final LongBinaryOperator accumulatorFunction;

        Extrema(long identity, LongBinaryOperator accumulatorFunction) {
            this.identity = identity;
            this.accumulatorFunction = accumulatorFunction;
        }
    }

    public static Optional<Long> find(Iterable<Long> xs, Extrema extrema) {
        if (!xs.iterator().hasNext()) return Optional.empty();
        LongAccumulator la = new LongAccumulator(extrema.accumulatorFunction, extrema.identity);
        xs.forEach(la::accumulate);
        return Optional.of(la.longValue());
    }

}
