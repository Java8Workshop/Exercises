/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikan
 */
public class ReverseReadWriteLine {

    public static void main(String[] args) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(new File("README.md").toURI()));
            Collections.reverse(lines);
            Files.write(Paths.get(new File("out/ch9.ex06.txt").toURI()), lines);
        } catch (IOException ex) {
            Logger.getLogger(ReverseReadWriteLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
