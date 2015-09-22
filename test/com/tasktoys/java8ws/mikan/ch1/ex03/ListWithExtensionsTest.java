/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex03;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.hasItem;

/**
 * @author mikan
 */
public class ListWithExtensionsTest {

    @Test(expected = NullPointerException.class)
    public void testGetFilesByExtension_pathNPE() {
        new ListWithExtensions().getFilesByExtension(null, ".java");
    }

    @Test(expected = NullPointerException.class)
    public void testGetFilesByExtension_extNPE() {
        new ListWithExtensions().getFilesByExtension("./", null);
    }

    @Test
    public void testGetFilesByExtension_currentDirectoryInput() {
        List<String> result = new ListWithExtensions().getFilesByExtension("../", ".md");
        assertThat(result, hasItem(containsString("README.md")));
    }
}
