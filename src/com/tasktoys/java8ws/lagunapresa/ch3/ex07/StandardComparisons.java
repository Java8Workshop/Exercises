package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

public class StandardComparisons {
    public static final Comparison DESCENDING = p -> Pair.of(p.s2, p.s1);
    public static final Comparison CASE_INSENSITIVE = p -> p.map(String::toLowerCase);
    public static final Comparison WHITE_INSENSITIVE = p -> p.map(s -> s.replaceAll("\\s", ""));
    private StandardComparisons() {
    }
}
