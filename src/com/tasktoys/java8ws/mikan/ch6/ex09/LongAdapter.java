/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch6.ex09;

/**
 * A {@link ComputableNumber} adapter for long values.
 *
 * @author mikan
 */
public class LongAdapter extends ComputableNumber {

    private static final long serialVersionUID = 1L;

    public LongAdapter(long value) {
        super(value);
    }

    @Override
    public ComputableNumber multiply(ComputableNumber number) {
        return new LongAdapter(longValue() * number.longValue());
    }

    @Override
    public ComputableNumber add(ComputableNumber number) {
        return new LongAdapter(longValue() + number.longValue());
    }
}