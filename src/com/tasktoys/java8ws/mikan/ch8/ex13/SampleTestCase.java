/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch8.ex13;

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

    public static void main(String[] args) {
        System.out.println("main() invoked.");
        SampleTestCase sample = new SampleTestCase();
        System.out.println("plus(): " + (sample.plus(0) == 1 ? "OK" : "NG"));
        System.out.println("minus(): " + (sample.minus(1) == 0 ? "OK" : "NG"));
    }
}
