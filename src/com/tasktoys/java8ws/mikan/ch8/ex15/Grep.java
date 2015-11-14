/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch8.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author mikan
 */
public class Grep {

    public static void main(String[] args) throws IOException {
        Predicate<String> predicate = Pattern.compile("^### (.+)").asPredicate();
        Files.lines(Paths.get("README.md")).filter(predicate).forEach(System.out::println);
    }
}
