/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex03;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class ListWithExtensions {

    public static void main(String[] args) {
        new ListWithExtensions().getFilesByExtension(System.getProperty("user.home"), ".txt").forEach(System.out::println);
    }

    public List<String> getFilesByExtension(String path, String ext) {
        Objects.requireNonNull(path);
        File dir = new File(path);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + dir);
        }
        List<String> list = Arrays.asList(dir.list((file, name) -> {
            return file.exists() && name.endsWith(ext); // "ext" captured.
        }));
        return list;
    }
}
