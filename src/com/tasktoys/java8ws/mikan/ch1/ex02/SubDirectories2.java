/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex02;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class SubDirectories2 implements FileFilter {

    public static void main(String[] args) {
        new SubDirectories2().getSubDirectories(System.getProperty("user.home")).forEach(s -> System.out.println(s));
    }

    private final List<File> list = new ArrayList<>();

    public List<File> getSubDirectories(String path) {
        Objects.requireNonNull(path);
        File dir = new File(path);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + dir);
        }
        list.clear();
        addSubDirectories(new File(path));
        return list;
    }

    private void addSubDirectories(File parent) {
        File[] file = parent.listFiles(this::accept);
        if (file == null) {
            return;
        }
        List<File> subDirs = Arrays.asList(file);
        if (!subDirs.isEmpty()) {
            list.addAll(subDirs);
            subDirs.forEach(d -> addSubDirectories(d));
        }
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
