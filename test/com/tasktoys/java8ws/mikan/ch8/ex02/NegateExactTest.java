/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch8.ex02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author mikan
 */
public class NegateExactTest {

    @Test
    public void testDoTryNagateExactError() {
        assertTrue(NegateExact.collectNegateExactError(Integer.MIN_VALUE));
        assertFalse(NegateExact.collectNegateExactError(0));
        assertFalse(NegateExact.collectNegateExactError(Integer.MAX_VALUE));
    }
}
