/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex01;

import java.util.Arrays;

/**
 *
 * @author mikan
 */
public class ArraysSort {

    public static void main(String[] args) {

        String[] words = {"hoge", "fuga", "piyo", "foo", "bar", "unko"};

        System.out.println("main thread: " + Thread.currentThread().getName()); // Result: main

        Arrays.sort(words, (first, second) -> {
            System.out.println("lambda thread: " + Thread.currentThread().getName()); // Result: main
            return Integer.compare(first.length(), second.length());
        });
    }
}
