/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex08;

import java.awt.Dimension;

/**
 * JavaBean wrapper of the {@code java.awt.Dimension}.
 *
 * @author mikan
 */
public class DimensionWrapper extends Dimension {

    private static final long serialVersionUID = 1L;

    public void setWidth(double width) {
        setSize(width, getHeight());
    }

    public void setHeight(double height) {
        setSize(getWidth(), height);
    }
}
