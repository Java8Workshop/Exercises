/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch9.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Try with resources by old style.
 *
 * @author mikan
 */
public class TryWithResources {

    private static final Logger LOG = Logger.getLogger(TryWithResources.class.getSimpleName());

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("README.md"));
            while (in.hasNext()) {
                System.out.println("" + in.next().toLowerCase());
            }
        } catch (FileNotFoundException ex) {
            LOG.severe(ex.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
