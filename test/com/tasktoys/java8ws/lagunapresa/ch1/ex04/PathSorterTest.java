package com.tasktoys.java8ws.lagunapresa.ch1.ex04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.tasktoys.java8ws.util.FileDeleter;

public class PathSorterTest {

	private File f0;
	private File f1;
	private File f2;
	private File f3;
	private File f4;
	private File f5;

	private static final FileSorter FS = new FileSorter();

	private static final File OUT = Paths.get("out").toFile();

	@Before
	public void setUp() throws Exception {
		FileDeleter.deleteIfExists(OUT);
		OUT.mkdirs();
		f0 = Files.createFile(Paths.get("out", "f0")).toFile();
		f1 = Files.createFile(Paths.get("out", "f1")).toFile();
		f2 = Files.createDirectories(Paths.get("out", "f2_d")).toFile();
		f3 = Files.createFile(Paths.get("out", "f3")).toFile();
		f4 = Files.createDirectories(Paths.get("out", "f4_d")).toFile();
		f5 = Files.createFile(Paths.get("out", "f5")).toFile();
	}

	@Test
	public void testSort() {
		File[] files = { f5, f4, f3, f2, f1, f0 };
		assertThat(Arrays.asList(FS.sort(files)),
				is(Arrays.asList(f2, f4, f0, f1, f3, f5)));
	}

}
