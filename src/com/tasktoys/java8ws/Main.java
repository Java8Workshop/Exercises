package com.tasktoys.java8ws;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 特に何もしないプロジェクト用メインクラスです。
 *
 * @author mikan
 */
public class Main {

    private static final Path OUT_DIR = Paths.get("out");

    public static void main(String[] args) {
        System.out.println("This is the main class.");
        // Create output directory.
        try {
            Files.createDirectory(OUT_DIR);
            System.out.println("The " + OUT_DIR + " directory created.");
        } catch (FileAlreadyExistsException ex) {
            System.out.println("The " + OUT_DIR + " directory already exists.");
        } catch (IOException ex) {
            System.out.println("The " + OUT_DIR + " directory creation failed: " + ex.getMessage());
        }
    }
}
