/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch8.ex02;

/**
 *
 * @author mikan
 */
public class NegateExact {

    public static boolean collectNegateExactError(int value) {
        try {
            Math.negateExact(value);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private NegateExact() {

    }
}
