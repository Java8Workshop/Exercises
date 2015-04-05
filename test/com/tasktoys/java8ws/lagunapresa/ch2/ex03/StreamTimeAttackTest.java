package com.tasktoys.java8ws.lagunapresa.ch2.ex03;

import com.tasktoys.java8ws.util.Resource;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StreamTimeAttackTest {

    private static final StreamTimeAttack TA = new StreamTimeAttack();

    private static final Path ALICE = Resource.get("ch2/alice30.txt");

    @Test
    public void compare() throws IOException {
        assertThat(TA.timeSerial(ALICE) < TA.timeParallel(ALICE), is(true));
    }

}
