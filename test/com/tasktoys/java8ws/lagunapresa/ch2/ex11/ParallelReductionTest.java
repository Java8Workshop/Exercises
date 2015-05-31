package com.tasktoys.java8ws.lagunapresa.ch2.ex11;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParallelReductionTest {

    @Test
    public void test() {
        LongStream ls1 = LongStream.range(0, 1_000_000L).parallel();

        assertThat(ls1.isParallel(), is(true));
        List<Long> li1 = ls1.map(i -> i * 2)
            .boxed()
            .collect(Collectors.toList());

        LongStream ls2 = LongStream.range(0, 1_000_000L);
        assertThat(ls2.isParallel(), is(false));
        List<Long> li2 = ls2.map(i -> i * 2)
            .boxed()
            .collect(Collectors.toList());

        assertThat(li1, is(li2));
    }

}
