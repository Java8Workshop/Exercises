package com.tasktoys.java8ws.lagunapresa.ch1.ex02;

import com.tasktoys.java8ws.util.FileDeleter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectoryTraversalerTest {

    private static final DirectoryTraversaler DT = new DirectoryTraversaler();

    private static final File OUT = Paths.get("out").toFile();

    private static final Path DUMMY_FILE = Paths.get("out", "dummy.txt");

    private static final File SUBDIR_1 = Paths.get("out", "subdir1").toFile();

    private static final File SUBDIR_2 = Paths.get("out", "subdir1", "subdir11").toFile();

    private static final File SUBDIR_3 = Paths.get("out", "subdir2").toFile();

    private static final List<File> SUBDIRS = Arrays.asList(SUBDIR_1, SUBDIR_2, SUBDIR_3);

    @Before
    public void setUp() throws Exception {
        FileDeleter.deleteIfExists(OUT);
        SUBDIRS.forEach(File::mkdirs);
        Files.createFile(DUMMY_FILE);
    }

    @Test
    public void testListDir() {
        assertThat(DT.listDir(OUT), is(SUBDIRS));
    }

    @Test
    public void testListDir2() {
        assertThat(DT.listDir2(OUT), is(SUBDIRS));
    }

    @Test
    public void testListDir3() throws IOException {
        assertThat(DT.listDir3(OUT), is(SUBDIRS));
    }

    // オマケ。
    @Test
    public void testPathEquality() {
        assertThat(Paths.get("out", "subdir1").toFile(),
                is(Paths.get("out", "subdir1").toFile()));
    }

}
