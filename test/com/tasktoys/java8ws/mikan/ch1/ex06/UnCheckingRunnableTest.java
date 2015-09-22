/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex06;

import org.junit.Test;

/**
 * @author mikan
 */
public class UnCheckingRunnableTest {

    @Test(expected = RuntimeException.class)
    public void testUnCheck_RE() {
        UnCheckingRunnable.RunnableEx func = () -> {
            throw new Exception("dummy exception");
        };
        UnCheckingRunnable.unCheck(func).run(); // expect RE
    }

    @Test(expected = Error.class)
    public void testUnCheck_ER() {
        UnCheckingRunnable.RunnableEx func = () -> {
            throw new Error("dummy error");
        };
        UnCheckingRunnable.unCheck(func).run(); // expect Error
    }

    @Test
    public void testUnCheck_normalExit() {
        UnCheckingRunnable.RunnableEx func = () -> {
            // no-op
        };
        UnCheckingRunnable.unCheck(func).run(); // no exception
    }
}
