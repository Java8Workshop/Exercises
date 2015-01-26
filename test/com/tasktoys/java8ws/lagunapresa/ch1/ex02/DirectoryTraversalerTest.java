package com.tasktoys.java8ws.lagunapresa.ch1.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tasktoys.java8ws.util.FileDeleter;

public class DirectoryTraversalerTest {

	private static final DirectoryTraversaler DT = new DirectoryTraversaler();

	private static final File OUT = Paths.get("out").toFile();

	private static final Path DUMMY = Paths.get("out", "dummy.txt");

	private static final List<File> SUBDIRS = Arrays.asList(
			Paths.get("out", "subdir1").toFile(),
			Paths.get("out", "subdir2").toFile(),
			Paths.get("out", "subdir1", "subdir11").toFile());

	@Before
	public void setUp() throws Exception {
		FileDeleter.deleteIfExists(OUT);
		SUBDIRS.forEach(File::mkdirs);
		Files.createFile(DUMMY);
	}

	@Test
	public void testListDir() {
		assertThat(DT.listDir(OUT), is(SUBDIRS));
	}

	// オマケ。
	@Test
	public void testPathEquality() {
		assertThat(Paths.get("out", "subdir1").toFile(),
				is(Paths.get("out", "subdir1").toFile()));
	}

}
