package com.tasktoys.java8ws.lagunapresa.ch2.ex05;

import java.math.BigInteger;
import java.util.stream.Stream;

public class LinearCongruentialGenerator {

    final BigInteger a;
    final BigInteger c;
    final BigInteger m;

    public static LinearCongruentialGenerator argsOf(long a, long c, long m) {
        return new LinearCongruentialGenerator(a, c, m);
    }

    public Stream<Long> generate(long seed) {
        return Stream.iterate(next(seed), this::next);
    }

    private long next(long prev) {
        return a.multiply(BigInteger.valueOf(prev)).add(c).mod(m).longValue();
    }

    private LinearCongruentialGenerator(long a, long c, long m) {
        this.a = BigInteger.valueOf(a);
        this.c = BigInteger.valueOf(c);
        this.m = BigInteger.valueOf(m);
    }

}
