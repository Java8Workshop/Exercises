/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch8.ex12;

/**
 * @author mikan
 */
public class SampleTestCase {

    @TestCase
    public int plus(int source) {
        System.out.println("Invoked!");
        return source + 1;
    }

    @TestCase
    public int minus(int source) {
        System.out.println("Invoked!");
        return source - 1;
    }
}
