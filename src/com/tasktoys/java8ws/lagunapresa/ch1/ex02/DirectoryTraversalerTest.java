package com.tasktoys.java8ws.lagunapresa.ch1.ex02;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectoryTraversalerTest {

	private static final Path OUT = Paths.get("out/");

	@Before
	public void setUp() throws Exception {
		Files.deleteIfExists(OUT);
	}

//	@Test
//	public void testListDir() {
//		DirectoryTraversaler dt = new DirectoryTraversaler();
//		Assert.assertThat(dt.listDir(new File("out/")), is Arrays.asList(new File("")));
//
//	}

}
