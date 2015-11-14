/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch6.ex02;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class IdGenerator {

    private static final IdGenerator INSTANCE = new IdGenerator();
    private final AtomicLong value;
    private final LongAdder adder;

    public static IdGenerator getInstance() {
        return INSTANCE;
    }

    public long generate() {
        long newId;
        adder.increment(); // adder isn't return value
        newId = value.incrementAndGet();
        return newId;
    }

    private IdGenerator() {
        value = new AtomicLong();
        adder = new LongAdder();
    }
}
