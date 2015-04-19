/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch2.ex05;

import java.util.stream.Stream;

/**
 *
 * @author mikan
 */
public class InfiniteRandom {

    public static void main(String[] args) {
        Stream<Long> stream = Stream.iterate(1L, n -> random(25214903917L, 11, (long) Math.pow(2, 48), n));
        stream.limit(10).forEach(System.out::println);
    }

    private static long random(long a, long c, long m, long x) {
        return (a * x + c) % m;
    }
}
