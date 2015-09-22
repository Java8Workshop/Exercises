/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex12;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

/**
 * @author mikan
 */
public class CompileOldLibraryTest {

    private static final String TARGET_SOURCE = "src/com/tasktoys/java8ws/mikan/ch1/ex12/oldlib/OldLibraryMain.java7";
    private static final String TARGET_CLASS_NAME = "OldLibraryMain";

    @Test(expected = NullPointerException.class)
    public void testCompile_classNameNPE() throws IOException {
        new CompileOldLibrary().compile(TARGET_SOURCE, null);
    }

    @Test
    public void testCompile_normalInput() throws IOException {
        boolean success = new CompileOldLibrary().compile(TARGET_SOURCE, TARGET_CLASS_NAME);
        assertFalse(success); // not source-compatible
    }
}
