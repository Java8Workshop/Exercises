/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
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
        File dir = new File(path);
        List<File> dirs = Arrays.asList(dir.listFiles(file -> {
            return file.isDirectory();
        }));
        List<File> files = Arrays.asList(dir.listFiles(file -> {
            return !file.isDirectory();
        }));
        List<File> list = new LinkedList<>();
        list.addAll(dirs);
        list.addAll(files);
        return list;
    }
}
