/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch2.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class WhatStreamOf {

    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        Stream<int[]> stream = Stream.of(values);
        System.out.println(stream); // java.util.stream.ReferencePipeline$Head@6d06d69c
        stream.peek(System.out::println) // [I@36baf30c
                .forEach(action -> {
                    for (int i = 0; i < action.length; i++) {
                        System.out.println(action[i]);
                    }
                });
        IntStream intStream = IntStream.of(values);
        System.out.println(intStream); // java.util.stream.IntPipeline$Head@7852e922
        intStream.forEach(System.out::println); // 1 4 9 16
    }
}
