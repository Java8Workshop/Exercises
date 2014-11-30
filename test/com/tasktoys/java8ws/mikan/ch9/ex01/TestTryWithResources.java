/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex01;

import org.junit.Test;

/**
 * Test for {@link TryWithResources}.
 *
 * @author mikan
 */
public class TestTryWithResources {

    @Test
    public void testMain_emptyInput() {
        TryWithResources.main(null); // Check exception
    }
}
