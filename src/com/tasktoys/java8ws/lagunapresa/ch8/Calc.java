package com.tasktoys.java8ws.lagunapresa.ch8;

public class Calc {
    public static long plus(int i, int j) {
        return (long) i + (long) j;
    }

    public static long minus(int i, int j) {
        return (long) i - (long) j;
    }

    public static long divide(int i, int j) {
        return Integer.divideUnsigned(i, j);
    }

    public static long compare(int i, int j) {
        return Integer.valueOf(i).compareTo(j);
    }
}
