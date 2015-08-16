/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch6.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author mikan
 */
public class WordLoader {

    private static final int THREAD_POOL_SIZE = 100;

    public Map<String, Set<File>> loadWords(Set<File> files) {
        Objects.requireNonNull(files);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        ConcurrentHashMap<String, Set<File>> result = new ConcurrentHashMap<>();
        files.forEach(f -> executorService.submit(() -> {
            String contents;
            try {
                contents = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                return;
            }
            String[] words = contents.split("[\\P{L}]+");
            for (String s : words) {
                result.merge(s.toLowerCase().trim(),
                        Collections.singletonMap(f, null).keySet(),
                        (Set<File> existingValue, Set<File> newValue) -> {
                            Set<File> fileSet = new HashSet<>(existingValue.size() + newValue.size());
                            fileSet.addAll(existingValue);
                            fileSet.addAll(newValue);
                            return fileSet;
                        });
            }
        }));
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            System.err.println("Interrputed. " + ex.getMessage());
        }
        return result;
    }
}
