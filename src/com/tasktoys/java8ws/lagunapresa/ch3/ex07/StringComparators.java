package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

import java.util.Comparator;
import java.util.stream.Stream;

public class StringComparators {

    public static Comparator<String> generate(Comparison... cs) {
        Comparison c = Stream.of(cs).reduce(s -> s, Comparison::and);
        return (s1, s2) -> {
            Pair arg = c.apply(Pair.of(s1, s2));
            return arg.s1.compareTo(arg.s2);
        };
    }

    private StringComparators() {
    }

}
