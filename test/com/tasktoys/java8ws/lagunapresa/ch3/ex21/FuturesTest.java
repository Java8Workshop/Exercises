package com.tasktoys.java8ws.lagunapresa.ch3.ex21;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

public class FuturesTest {

    @Test
    public void isDone() {
        Future<Integer> fu = CompletableFuture.supplyAsync(() -> 1);

        assumeTrue(fu.isDone());
        Future<String> sf = Futures.map(fu, i -> repeat(5, String.valueOf(i)));

        try {
            assertThat(sf.get(), is("11111"));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void isNotDone() {
        Future<Integer> fu = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1;
                }
        );

        assumeThat(fu.isDone(), is(false));
        Future<String> sf = Futures.map(fu, i -> repeat(5, String.valueOf(i)));

        try {
            sf.get(1L, TimeUnit.MILLISECONDS);
            fail();
        } catch (Exception e) {
            assertThat(sf.isDone(), is(false));
        }
    }

    private String repeat(int times, String s) {
        return Stream.generate(() -> s)
                .limit(times)
                .reduce(new StringBuilder(),
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
    }

}