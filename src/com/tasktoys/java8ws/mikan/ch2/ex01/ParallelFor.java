/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch2.ex01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author mikan
 */
public class ParallelFor {

    private static final int SEGMENT_SIZE = 100;
    private static final int MIN_COUNT_LENGTH = 12;

    public static void main(String[] args) throws IOException {
        ParallelFor myClass = new ParallelFor();
        myClass.fetchAliceDotTxt();
        String contents = new String(Files.readAllBytes(Paths.get("out/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        System.out.println("Number of words: " + words.size());
        System.out.println("for:\t" + myClass.countSequential(words));
        System.out.println("thread:\t" + myClass.countParallel(words));
    }

    private void fetchAliceDotTxt() {
        if (new File("out/alice.txt").exists()) {
            System.out.println("alice.txt already found. Download skipping.");
            return;
        }
        String target = "http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt";
        try (InputStream input = new URL(target).openStream()) {
            Files.copy(input, Paths.get("out/alice.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IOException" + ex.getMessage());
        }
    }

    private int countSequential(List<String> words) {
        int count = 0;
        for (String w : words) {
            if (w.length() > MIN_COUNT_LENGTH) {
                count++;
            }
        }
        return count;
    }

   private int countParallel(List <String> words) {
       int count = 0;
        ExecutorService exec = Executors.newSingleThreadExecutor();
        List<Future<Integer>> futures = new ArrayList<>();
        int begin = 0;
        int end = SEGMENT_SIZE;
        while (true) {
            Future<Integer> future;
            if (end >= words.size()) {
                end = words.size();
                future = exec.submit(new Counter(words.subList(begin, end)));
                // System.out.println("[2] " + begin + " " + end);
                futures.add(future);
                break;
            } else {
                future = exec.submit(new Counter(words.subList(begin, end)));
                // System.out.println("[1] " + begin + " " + end);
                futures.add(future);
                begin = end;
                end = begin + SEGMENT_SIZE;
            }
        }
        for (Future<Integer> future : futures) {
            try {
                int tmpCount = future.get();
                count += tmpCount;
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e);
            }
        }
        exec.shutdown();
        return count;
   }

    private static class Counter implements Callable<Integer> {

        private final List<String> segment;
        private int count = 0;

        public Counter(List<String> segment) {
            this.segment = segment;
        }

        @Override
        public Integer call() throws Exception {
            for (String w : segment) {
                if (w.length() > MIN_COUNT_LENGTH) {
                    count++;
                }
            }
            return count;
        }
    }
}
