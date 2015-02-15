/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class DirectoryFirstLister {

    public static void main(String[] args) {
        new DirectoryFirstLister().listFiles("./").forEach(file -> System.out.println(file.getName()));
    }

    public List<File> listFiles(String path) {
        Objects.requireNonNull(path);
        File[] list = new File(path).listFiles();
        Arrays.sort(list, (File a, File b) -> {
            if (a.isDirectory() && !b.isDirectory()) {
                return -1;
            } else if (!a.isDirectory() && b.isDirectory()) {
                return 1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        });
        return Arrays.asList(list);
    }
}
