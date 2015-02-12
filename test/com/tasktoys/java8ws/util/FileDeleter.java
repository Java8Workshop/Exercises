package com.tasktoys.java8ws.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public final class FileDeleter {

	private static final FileFilter ACCEPT_ALL = f -> true;

	public static void deleteIfExists(File root) {
		deleteIfExists(root, ACCEPT_ALL);
	}

	public static void deleteIfExists(File root, FileFilter filter) {
		if (root.isDirectory()) {
			Stream.of(root.listFiles()).forEach(f -> FileDeleter.deleteIfExists(f, filter));
		} else {
			try {
				if (filter.accept(root)) {
					Files.deleteIfExists(root.toPath());
				}
			} catch (IOException e) {
				fail(e.toString());
			}
		}
	}

	// utility class
	private FileDeleter() {
		;
	}

}
