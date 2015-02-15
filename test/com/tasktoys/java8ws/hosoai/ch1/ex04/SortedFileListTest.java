package com.tasktoys.java8ws.hosoai.ch1.ex04;

import java.io.File;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class SortedFileListTest {
	SortedFileList target;

	@Before
	public void setUp() throws Exception {
		target = new SortedFileList();
	}

	@Test
	public void test() {
		File[] files = target.dirFirstSort(Paths.get(".").toFile().listFiles());
		Stream.of(files).forEach(System.out::println);
	}
}
