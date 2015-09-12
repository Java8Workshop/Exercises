/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch8.ex01;

/**
 *
 * @author mikan
 */
public class UnsignedInt {

    private final int value;

    public UnsignedInt() {
        value = 0;
    }

    public UnsignedInt(int value) {
        this.value = value;
    }

    public int add(int value) {
        return (int) (Integer.toUnsignedLong(this.value) + Integer.toUnsignedLong(value));
    }

    public int sub(int value) {
        return (int) (Integer.toUnsignedLong(this.value) - Integer.toUnsignedLong(value));
    }

    public int div(int value) {
        return (int) Long.divideUnsigned(Integer.toUnsignedLong(this.value), Integer.toUnsignedLong(value));
    }

    public int compare(int value) {
        return Long.compare(Integer.toUnsignedLong(this.value), Integer.toUnsignedLong(value));
    }

    public int getIntValue() {
        return value;
    }
}
