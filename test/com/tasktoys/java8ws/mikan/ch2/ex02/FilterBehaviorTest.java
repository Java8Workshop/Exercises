/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch2.ex02;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author mikan
 */
public class FilterBehaviorTest {

    private static final String INPUT_FILE = "test/res/ch2/alice30.txt";

    @Test
    public void testPrint_normalInput() throws IOException {
        FilterBehavior filter = new FilterBehavior();
        String contents = new String(Files.readAllBytes(Paths.get(INPUT_FILE)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        System.out.println("Number of words: " + words.size());
        long count = words.stream().filter(w -> {
            boolean result = w.length() > 12;
            filter.print(result);
            return result;
        }).limit(5).count();
        System.out.println();
        System.out.println("count: " + count);
    }
}
