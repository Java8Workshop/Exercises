package com.tasktoys.java8ws.lagunapresa.ch6.ex04;

import com.tasktoys.java8ws.lagunapresa.ch6.ex04.LongExtremaFinder.Extrema;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LongExtremaFinderTest {

    private static final List<Long> LONGS = LongStream.rangeClosed(1L, 1_000_000L)
        .collect(ArrayList<Long>::new, ArrayList::add, ArrayList::addAll);

    @Test
    public void testFindMaximal() {
        assertThat(LongExtremaFinder.find(LONGS, Extrema.MAXIMAL), is(Optional.of(1_000_000L)));
    }

    @Test
    public void testFindMinimal() {
        assertThat(LongExtremaFinder.find(LONGS, Extrema.MINIMAL), is(Optional.of(1L)));
    }

    @Test
    public void testEmpty() {
        assertThat(LongExtremaFinder.find(Collections.emptyList(), Extrema.MAXIMAL), is(Optional.empty()));
    }

}