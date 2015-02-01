package com.tasktoys.java8ws.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public final class FileDeleter {

	public static void deleteIfExists(File root) {
		if (root.isDirectory()) {
			Arrays.asList(root.listFiles()).forEach(FileDeleter::deleteIfExists);
		}
		try {
			Files.deleteIfExists(root.toPath());
		} catch (IOException e) {
			fail();
		}
	}

	// utility class
	private FileDeleter() {
		;
	}

}