/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch6.ex09;

import java.math.BigInteger;

/**
 * A {@link ComputableNumber} adapter for {@link BigInteger} values.
 *
 * @author mikan
 */
public class BigIntegerAdapter extends ComputableNumber {
    private static final long serialVersionUID = 1L;

    public BigIntegerAdapter(BigInteger value) {
        super(value);
    }

    @Override
    public ComputableNumber multiply(ComputableNumber number) {
        return new BigIntegerAdapter(((BigInteger) get()).multiply(((BigInteger) number.get())));
    }

    @Override
    public ComputableNumber add(ComputableNumber number) {
        return new BigIntegerAdapter(((BigInteger) get()).add(((BigInteger) number.get())));
    }
}
