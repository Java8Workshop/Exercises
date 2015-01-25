/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex03;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class ListWithExtensions {

    public static void main(String[] args) {
        new ListWithExtensions().getFilesByExtension(System.getProperty("user.home"), ".txt").forEach(s -> System.out.println(s));
    }

    public List<File> getFilesByExtension(String path, String ext) {
        Objects.requireNonNull(path);
        File dir = new File(path);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + dir);
        }
        List<File> list = new ArrayList<>();
        File[] file = dir.listFiles(p -> {
            return p.isFile() && p.getName().endsWith(ext); // "ext" captured.
        });
        List<File> subDirs = Arrays.asList(file);
        if (!subDirs.isEmpty()) {
            list.addAll(subDirs);
        }
        return list;
    }
}
