/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch2.ex07;

import java.util.stream.Stream;

/**
 *
 * @author mikan
 */
public class Boss {

    public static void main(String[] args) {
        Stream<String> infinite = Stream.generate(() -> "yeah!").parallel();
        System.out.println("result:" + isFinite(infinite));
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        return stream.count() >= 0; // DO NOT RUN!
    }
}
