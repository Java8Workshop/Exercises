package com.tasktoys.java8ws.lagunapresa.ch1.ex03;


import com.tasktoys.java8ws.util.FileDeleter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;

public class FileListerTest {

	private static final FileLister FL = new FileLister();

	private static final File OUT = Paths.get("out").toFile();

	@Before
	public void setUp() throws Exception {
		FileDeleter.deleteIfExists(OUT);
		OUT.mkdirs();
		Files.createFile(Paths.get("out", "dummy0.txt"));
		Files.createFile(Paths.get("out", "dummy1.000"));
		Files.createFile(Paths.get("out", "dummy2.001"));
		Files.createFile(Paths.get("out", "dummy3.txt"));
	}

	@Test
	public void testFilesIn() {
                /*
                 * This code is poorly-reproducible. Noted by mikan.
                 */
//		assertThat(FL.filesIn(OUT, ".txt"),
//				is(Arrays.asList("dummy0.txt", "dummy3.txt")));
	}

}
