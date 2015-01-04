/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.namikawa.ch9.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author takanori
 */
public class ReverseStrings2 {

    public static void main(String args[]) throws IOException {
        Path p = Paths.get("/", "Users", "takanori", "workspace", "test.txt");
        List<String> list = Files.readAllLines(p);
        Collections.reverse(list);

        System.out.println(list);
    }
}
