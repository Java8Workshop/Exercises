package com.tasktoys.java8ws.lagunapresa.ch2.ex07;

import java.util.Spliterator;
import java.util.stream.Stream;

public class FinitenessChecker {

    // Answer to question is YES.
    // Because the signature should be 'public static boolean isFinite(Stream<?> stream)' (T is never used).

    public static <T> boolean isFinite(Stream<T> stream) {
        return (stream.spliterator().characteristics() & Spliterator.SIZED) != 0b0; // XXX
    }

}
