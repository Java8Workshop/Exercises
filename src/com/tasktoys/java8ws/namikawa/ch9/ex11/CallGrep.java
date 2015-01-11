/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.namikawa.ch9.ex11;

import java.nio.file.Paths;
import java.io.File;

/**
 *
 * @author takanori
 */
public class CallGrep {

    public static void main(String args[]) throws Exception {
        File dir = new File("/Users/takanori");
        ProcessBuilder pb = new ProcessBuilder("grep", "-r", "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$", "/Users/takanori/workspace");
        pb.redirectOutput(Paths.get("/Users/takanori/workspace/result.txt").toFile());
        Process process = pb.start();
        process.waitFor();
    }
}
