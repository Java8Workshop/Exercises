/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch2.ex02;

import com.tasktoys.java8ws.mikan.ch2.ex01.ParallelFor;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mikan
 */
public class FilterBehavior {

    private int cursor = 0;

    public void print(boolean result) {
        System.out.print(result ? "#" : ".");
        cursor++;
        if (cursor >= 80) {
            System.out.println();
            cursor = 0;
        }
    }
}
