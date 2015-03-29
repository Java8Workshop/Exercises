package com.tasktoys.java8ws.lagunapresa.ch2.ex01;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParStreamTest {

    private static final ParStream PS = new ParStream();

    private static final Path ALICE = Paths.get("test/com/tasktoys/java8ws/lagunapresa/ch2/ex01/alice30.txt");

    @Test
    public void test() throws IOException {
        int result = PS.cntSerial(ALICE);
        assertThat(result, is(16));
    }

    @Test
    public void testPar() throws IOException {
        long result = PS.cntParallel(ALICE);
        assertThat(result, is(16L));
    }

}
