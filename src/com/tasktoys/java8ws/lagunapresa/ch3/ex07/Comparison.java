package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

import java.util.function.Function;

@FunctionalInterface
public interface Comparison extends Function<Pair, Pair> {
    static Comparison and(Comparison first, Comparison second) {
        return (Pair x) -> second.apply(first.apply(x));
    }
}
