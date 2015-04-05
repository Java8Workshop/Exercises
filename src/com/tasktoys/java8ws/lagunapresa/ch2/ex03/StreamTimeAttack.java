package com.tasktoys.java8ws.lagunapresa.ch2.ex03;

import com.tasktoys.java8ws.lagunapresa.ch2.ex01.ParStream;

import java.io.IOException;
import java.nio.file.Path;

public class StreamTimeAttack {

    public long timeSerial(Path res) throws IOException {
        long begin = System.nanoTime();
        new ParStream().cntSerial(res);
        return System.nanoTime() - begin;
    }

    public long timeParallel(Path res) throws IOException {
        long begin = System.nanoTime();
        new ParStream().cntParallel(res);
        return System.nanoTime() - begin;
    }

}
