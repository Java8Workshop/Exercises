/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch6.ex05;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mikan
 */
public class WordLoaderTest {

    @BeforeClass
    public static void fetchAliceDotTxt() {
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

    @BeforeClass
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

    @Test(expected = NullPointerException.class)
    public void testLoadWords_NPE() {
        new WordLoader().loadWords(null);
    }

    @Test
    public void testLoadWords_largeInput() {
        Set<File> files = new HashSet<>();
        files.add(new File("out/alice.txt"));
        files.add(new File("out/war_and_peace.txt"));
        Instant begin = Instant.now();
        Map<String, Set<File>> result = new WordLoader().loadWords(files);
        Instant end = Instant.now();
        System.out.println("Number of words: " + result.size());
        System.out.println("Time: " + Duration.between(begin, end).toMillis() + " msec.");
        assertFalse(result.isEmpty());
        Assert.assertEquals(2, result.get("a").size());
    }

    @Test
    public void testLoadWords_readmeInput() {
        Set<File> files = new HashSet<>();
        files.add(new File("README.md"));
        Instant begin = Instant.now();
        Map<String, Set<File>> result = new WordLoader().loadWords(files);
        Instant end = Instant.now();
        System.out.println("Number of words: " + result.size());
        System.out.println("Time: " + Duration.between(begin, end).toMillis() + " msec.");
        assertFalse(result.isEmpty());
    }
}
