/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex04;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.hasItem;

/**
 * @author mikan
 */
public class DirectoryFirstListerTest {

    @Test(expected = NullPointerException.class)
    public void testListFiles_NPE() {
        new DirectoryFirstLister().listFiles(null);
    }

    @Test
    public void testListFiles_normalInput() {
        List<File> files = new DirectoryFirstLister().listFiles("./");
        List<String> fileNames = Arrays.asList(files.stream().map(File::getName).toArray(String[]::new));
        assumeThat(fileNames, hasItem(containsString("src")));
        assumeThat(fileNames, hasItem(containsString("build.xml")));
        assumeThat(fileNames, hasItem(containsString("README.md")));
        assertTrue(files.get(0).isDirectory());
        assertTrue(!files.get(files.size() - 1).isDirectory());
    }
}
