/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex10;

import java.util.Objects;

import com.tasktoys.java8ws.mikan.ch9.ex09.LabeledPoint;

/**
 * The LabeledPoint2 class.
 *
 * @author mikan
 */
public class LabeledPoint2 extends LabeledPoint implements Comparable<LabeledPoint2> {

    public LabeledPoint2(int x, int y, String label) {
        super(x, y, label);
    }

    @Override
    public int compareTo(LabeledPoint2 other) {
	Objects.requireNonNull(other);
        int diff = Integer.compare(getX(), other.getX());
        if (diff != 0) {
            return diff;
        }
        return Integer.compare(getY(), other.getY());
    }
}
