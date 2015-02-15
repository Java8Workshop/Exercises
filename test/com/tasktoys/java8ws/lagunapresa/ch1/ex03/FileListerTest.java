package com.tasktoys.java8ws.lagunapresa.ch1.ex03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tasktoys.java8ws.util.FileDeleter;

public class FileListerTest {

	private static final FileLister FL = new FileLister();

	private static final File OUT = Paths.get("out").toFile();

	@Before
	public void setUp() throws Exception {
		FileDeleter.deleteIfExists(OUT, f -> !f.getName().equals("README"));
		OUT.mkdirs();
		Files.createFile(Paths.get("out", "dummy0.txt"));
		Files.createFile(Paths.get("out", "dummy1.000"));
		Files.createFile(Paths.get("out", "dummy2.001"));
		Files.createFile(Paths.get("out", "dummy3.txt"));
	}

	@Test
	public void testFilesIn() {
		List<String> result = FL.filesIn(OUT, ".txt");
		assertThat(result.size(), is(2));
		assertThat(result.contains("dummy0.txt"), is(true));
		assertThat(result.contains("dummy3.txt"), is(true));
	}

}
