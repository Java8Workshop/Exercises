/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex19;

import java.util.stream.Stream;

/**
 * @author mikan
 */
public class ReduceUser {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "2", "3");
        // <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        Integer result1 = stringStream.reduce(0, (Integer i, String s) -> i + Integer.parseInt(s), (i1, i2) -> i1 + i2);
        // NOTE: String "s" is used for both parameter type ("super") and return type ("extends").
        System.out.println("result: " + result1);
    }
}
