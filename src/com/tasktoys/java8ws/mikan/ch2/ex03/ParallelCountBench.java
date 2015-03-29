/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch2.ex03;

import com.tasktoys.java8ws.mikan.ch2.ex01.ParallelFor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mikan
 */
public class ParallelCountBench {

    public static void main(String[] args) throws IOException {
        fetchWarAndPeace();
        String contents = new String(Files.readAllBytes(Paths.get("out/war_and_peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        ParallelFor pf = new ParallelFor(12, 10);
        
        // Test run
        countSequential(words);
        countParallel(words);
        pf.countSequential(words);

        // Metrics run
        long beginParallel = System.nanoTime();
        long countPararell = countParallel(words);
        long endParallel = System.nanoTime();
        long beginSequential = System.nanoTime();
        long countSequential = countSequential(words);
        long endSequential = System.nanoTime();
        long beginPf = System.nanoTime();
        long countPf = pf.countSequential(words);
        long endPf = System.nanoTime();
        System.out.println("Pararell:\t" + (endParallel - beginParallel) + " [" + countPararell + "]");
        System.out.println("Sequential:\t" + (endSequential - beginSequential) + " [" + countSequential + "]");
        System.out.println("ParallelFor:\t" + (endPf - beginPf) + " [" + countPf + "]");

        // Take 1
        // Pararell:    7045720 [1946] 2
        // Sequential:  6982571 [1946] 1 FASTEST!
        // ParallelFor: 7318455 [1946] 3
        // Take 2
        // Pararell:    8094675 [1946] 3
        // Sequential:  6821456 [1946] 1 FASTEST!
        // ParallelFor: 7967695 [1946] 2
        // Take 3
        // Pararell:    6221370 [1946] 1 FASTEST!
        // Sequential:  7220489 [1946] 2
        // ParallelFor: 7324258 [1946] 3
        // Take 4
        // Pararell:    6863100 [1946] 1 FASTEST!
        // Sequential:  8007632 [1946] 3
        // ParallelFor: 7996368 [1946] 2
    }

    private static long countParallel(List<String> words) {
        return words.parallelStream().filter(w -> w.length() > 12).count();
    }

    private static long countSequential(List<String> words) {
        return words.stream().filter(w -> w.length() > 12).count();
    }

    public static void fetchWarAndPeace() {
        if (new File("out/war_and_peace.txt").exists()) {
            System.out.println("war_and_peace.txt already found. Download skipping.");
            return;
        }
        String target = "http://www.gutenberg.org/files/2600/2600.txt";
        try (InputStream input = new URL(target).openStream()) {
            Files.copy(input, Paths.get("out/war_and_peace.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IOException" + ex.getMessage());
        }
    }
}
