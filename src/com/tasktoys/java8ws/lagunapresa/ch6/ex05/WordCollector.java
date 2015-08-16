package com.tasktoys.java8ws.lagunapresa.ch6.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WordCollector {

    public static Map<String, Set<File>> collect(Collection<Path> files) {
        ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();
        files.parallelStream()
            .forEach(path ->
                readAndSplit(path).forEach(s ->
                    map.merge(s, singleSet(path.toFile()), WordCollector::addAll)));
        return map;
    }

    private static List<String> readAndSplit(Path res) {
        try {
            String contents = new String(
                Files.readAllBytes(res),
                StandardCharsets.UTF_8);
            return Arrays.asList(contents.split("[\\P{L}]+"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <E> Set<E> singleSet(E e) {
        Set<E> s = new HashSet<>();
        s.add(e);
        return s;
    }

    private static <E> Set<E> addAll(Set<E> s1, Set<E> s2) {
        s1.addAll(s2);
        return s1;
    }

    private WordCollector() {
    }

}
