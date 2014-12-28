/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.namikawa.ch9.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author takanori
 */
public class ReverseStrings {

    public static void main(String args[]) throws IOException {
        Path p = Paths.get("/", "Users", "takanori", "workspace", "test.txt");
        byte[] bytes = Files.readAllBytes(p);
        String str = new String(bytes, StandardCharsets.UTF_8);
        String str2;

        StringBuffer sb = new StringBuffer(str);
        str2 = sb.reverse().toString();

        System.out.println(str2);
    }
}
