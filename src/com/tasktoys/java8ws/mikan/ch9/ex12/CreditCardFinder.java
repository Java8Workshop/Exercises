/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find credit card numbers from home directory.
 *
 * <p>
 * Sample output:
 * <pre>
 * 5678-5678-5678-5678 (C:\Users\yutaka\test2.txt)
 * 9999-9999-9999-9999 (C:\Users\yutaka\Downloads\test3.txt)
 * 1234-1234-1234-1234 (C:\Users\yutaka\test.txt)
 * </pre>
 * </p>
 *
 * @author mikan
 */
public class CreditCardFinder {

    private static final String FINDSTR_REGEXP = "\"[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9]\""; // findstr has character length limitation.
    private static final String FINDSTR_SUFFIX = "\\*.txt";
    private static final Path TMP_FILE_PATH = Paths.get("out/ch9.ex12.txt");

    public Map<String, String> find(String path) {
        return find(path, true, true);
    }

    public Map<String, String> find(String path, boolean findSubFolder, boolean ignoreCase) {
        // Prepare
        System.out.println("PATH: " + path + ", SUFFIX: " + FINDSTR_SUFFIX);
        ProcessBuilder builder = new ProcessBuilder("findstr", "/s", "/i", FINDSTR_REGEXP, path + FINDSTR_SUFFIX);
        builder.redirectOutput(TMP_FILE_PATH.toFile());
        // Execute
        try {
            Process process = builder.start();
            process.waitFor();
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex);
            return null;
        }
        // Load result
        List<String> lines;
        try {
            lines = Files.readAllLines(TMP_FILE_PATH);
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }
        // Parse result
        Map<String, String> result = new HashMap<>(lines.size());
        lines.stream().filter((line) -> (line.contains(":"))).forEach((line) -> {
            int splitPos = line.lastIndexOf(':');
            String file = line.substring(0, splitPos);
            String card = line.substring(splitPos + 1);
            result.put(file, card);
        });
        return result;
    }
}
