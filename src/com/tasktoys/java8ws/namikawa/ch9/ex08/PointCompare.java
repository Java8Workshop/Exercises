/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.namikawa.ch9.ex08;

import java.awt.Point;
import java.io.IOException;

/**
 *
 * @author takanori
 */
public class PointCompare {

    int x;
    int y;

    public int compareTo(Point other) {
        return (x < other.x) ? -1 : ((x == other.x) ? 0 : 1);
    }

    public static void main(String args[]) throws IOException {

        PointCompare p1 = new PointCompare();
        p1.x = 2000000000;
        p1.y = 2000000000;

        Point p2 = new Point();
        p2.x = -2000000000;
        p2.y = 0;

        System.out.println("p1 = (" + p1.x + ", " + p1.y + ")");
        System.out.println("p2 = (" + p2.x + ", " + p2.y + ")");

        System.out.println("Call compareTo...");
        System.out.println(p1.compareTo(p2));
    }

}
