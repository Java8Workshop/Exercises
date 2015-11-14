/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch8.ex03;

/**
 *
 * @author mikan
 */
public class GcdCalculator {

    public static int gcdWithPercent(int a, int b) {
        int currentA = Math.abs(a);
        int currentB = Math.abs(b);
        if (currentA < currentB) {
            currentA = Math.abs(b);
            currentB = Math.abs(a);
        }
        if (currentB == 0) {
            return a;
        }
        int newB = currentA % currentB;
        int newA = currentB;
        return gcdWithPercent(newA, newB);
    }

    public static int gcdWithFloorMod(int a, int b) {
        int currentA = Math.abs(a);
        int currentB = Math.abs(b);
        if (a < b) {
            currentA = Math.abs(b);
            currentB = Math.abs(a);
        }
        if (currentB == 0) {
            return a;
        }
        int newB = Math.floorMod(currentA, currentB);
        int newA = currentB;
        return gcdWithFloorMod(newA, newB);
    }

    public static int gcdWithRem(int a, int b) {
        int currentA = Math.abs(a);
        int currentB = Math.abs(b);
        if (a < b) {
            currentA = Math.abs(b);
            currentB = Math.abs(a);
        }
        if (currentB == 0) {
            return a;
        }
        int newB = rem(currentA, currentB);
        int newA = currentB;
        return gcdWithRem(newA, newB);
    }

    private static int rem(int a, int b) {
        return Integer.remainderUnsigned(a, b);
    }

    private GcdCalculator() {

    }
}
