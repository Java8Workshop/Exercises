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
        //   serial try 5: 0.169, 0.163, 0.100, 0.108, 0.088
        // parallel try 5: 0.717, 0.749, 0.742, 0.751, 0.697
        assertThat(TA.timeSerial(ALICE) < TA.timeParallel(ALICE), is(true));
    }

}
