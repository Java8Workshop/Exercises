package com.tasktoys.java8ws.lagunapresa.ch6.ex03;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BenchmarkAdder {

    @Test
    public void testAtomicLong() {
        AtomicLong al = new AtomicLong();
        List<Thread> ts = Stream.generate(() ->
            new Thread(() -> {
                for (int j = 0; j < 100_000; j++) al.incrementAndGet();
            }))
            .limit(1000)
            .collect(Collectors.toList());
        long begin = System.nanoTime();
        ts.forEach(Thread::start);
        ts.forEach(thread -> {
            try {
                thread.join();
            } catch (Exception e) {
            }
        });
        assertThat(al.longValue(), is(100_000_000L));
        System.out.println(String.format("testAtomicLong elapsed time %s ms", (System.nanoTime() - begin) / 1000L));
    }

    @Test
    public void testLongAdder() {
        LongAdder la = new LongAdder();
        List<Thread> ts = Stream.generate(() ->
            new Thread(() -> {
                for (int j = 0; j < 100_000; j++) la.increment();
            }))
            .limit(1000)
            .collect(Collectors.toList());
        long begin = System.nanoTime();
        ts.forEach(Thread::start);
        ts.forEach(thread -> {
            try {
                thread.join();
            } catch (Exception e) {
            }
        });
        assertThat(la.longValue(), is(100_000_000L));
        System.out.println(String.format("testLongAdder elapsed time %s ms", (System.nanoTime() - begin) / 1000L));
    }

}
