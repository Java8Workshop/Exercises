/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex02;

import java.io.File;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test for {@link TryWithResources2}.
 *
 * @author mikan
 */
public class TestTryWithResources2 {

    @Test
    public void testMain_emptyInput() throws Throwable {
        TryWithResources2.main(null); // Check exception
        File file = new File("out/ch9.ex02.txt");
        assertTrue(file.exists());
    }
}
