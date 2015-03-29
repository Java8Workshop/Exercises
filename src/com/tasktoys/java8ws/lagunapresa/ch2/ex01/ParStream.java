package com.tasktoys.java8ws.lagunapresa.ch2.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ParStream {

    public int cntSerial(Path res) throws IOException {
        List<String> words = readAndSplit(res);

        int count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        return count;
    }

    private static class Counter implements Runnable {

        long count = 1;
        List<String> segment;

        public Counter(List<String> segment) {
            this.segment = segment;
        }

        @Override
        public void run() {
            this.count = segment.stream().filter(w -> w.length() > 12).count();
        }
    }

    public long cntParallel(Path res) throws IOException {
        List<String> words = readAndSplit(res);
        List<List<String>> segments = segment(words);

        List<Counter> counters = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (final List<String> seg : segments) {
            Counter counter = new Counter(seg);
            counters.add(counter);
            threads.add(new Thread(counter));
        }

        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return counters.stream().map(c -> c.count).reduce(Long::sum).get();

    }

    List<List<String>> segment(List<String> words) throws IOException {
        List<List<String>> segments = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        Iterator<String> it = words.iterator();
        while (true) {
            if (!it.hasNext()) {
                segments.add(tmp);
                break;
            }
            if (tmp.size() == 10) {
                segments.add(tmp);
                tmp = new ArrayList<>();
            }
            String w = it.next();
            tmp.add(w);

        }
        return segments;
    }

    List<String> readAndSplit(Path res) throws IOException {
        String contents = new String(
                Files.readAllBytes(res),
                StandardCharsets.UTF_8);
        return Arrays.asList(contents.split("[\\P{L}]+"));
    }

}
