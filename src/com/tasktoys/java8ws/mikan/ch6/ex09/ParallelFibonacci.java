/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch6.ex09;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author mikan
 */
public class ParallelFibonacci {

    private ParallelFibonacci() {
        // static use only
    }

    public static long fibonacciAsLong(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + " is zero or minus value.");
        }
        Matrix[] array = new Matrix[n];
        Arrays.parallelSetAll(array, i -> Matrix.of(1, 1, 1, 0));
        Arrays.parallelPrefix(array, Matrix::multiply);
        return array[n - 1].at(0).longValue();
    }

    public static BigInteger fibonacciAsBigInteger(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + " is zero or minus value.");
        }
        Matrix[] array = new Matrix[n];
        Arrays.parallelSetAll(array, i -> Matrix.of(
                BigInteger.valueOf(1), BigInteger.valueOf(1),
                BigInteger.valueOf(1), BigInteger.valueOf(0)));
        Arrays.parallelPrefix(array, Matrix::multiply);
        return (BigInteger) array[n - 1].at(0).get();
    }

    private static class Matrix {

        private final ComputableNumber[][] value;

        private Matrix(ComputableNumber[][] value) {
            this.value = value;
        }

        private static Matrix of(ComputableNumber v1, ComputableNumber v2,
                ComputableNumber v3, ComputableNumber v4) {
            ComputableNumber[][] value = new ComputableNumber[2][2];
            value[0] = Stream.of(v1, v2).toArray(ComputableNumber[]::new);
            value[1] = Stream.of(v3, v4).toArray(ComputableNumber[]::new);
            return new Matrix(value);
        }

        public static Matrix of(long v1, long v2, long v3, long v4) {
            return of(new LongAdapter(v1), new LongAdapter(v2),
                    new LongAdapter(v3), new LongAdapter(v4));
        }

        public static Matrix of(BigInteger v1, BigInteger v2, BigInteger v3, BigInteger v4) {
            return of(new BigIntegerAdapter(v1), new BigIntegerAdapter(v2),
                    new BigIntegerAdapter(v3), new BigIntegerAdapter(v4));
        }

        public Matrix multiply(Matrix v) {
            return of(
                    at(0).multiply(v.at(0)).add(at(2).multiply(v.at(1))),
                    at(1).multiply(v.at(0)).add(at(3).multiply(v.at(1))),
                    at(0).multiply(v.at(2)).add(at(2).multiply(v.at(3))),
                    at(1).multiply(v.at(2)).add(at(3).multiply(v.at(3))));
        }

        private ComputableNumber at(int n) {
            switch (n) {
                case 0:
                case 1:
                    return value[0][n];
                case 2:
                case 3:
                    return value[1][n - 2];
                default:
                    throw new IllegalArgumentException("Out of matrix: " + n);
            }
        }
    }

    private abstract static class ComputableNumber extends Number {

        private static final long serialVersionUID = 1L;
        private final Number number;

        protected ComputableNumber(Number number) {
            this.number = number;
        }

        @Override
        public int intValue() {
            return number.intValue();
        }

        @Override
        public long longValue() {
            return number.longValue();
        }

        @Override
        public float floatValue() {
            return number.floatValue();
        }

        @Override
        public double doubleValue() {
            return number.doubleValue();
        }

        public abstract ComputableNumber multiply(ComputableNumber number);

        public abstract ComputableNumber add(ComputableNumber number);

        protected Number get() {
            return number;
        }
    }

    private static class BigIntegerAdapter extends ComputableNumber {

        private static final long serialVersionUID = 1L;

        private BigIntegerAdapter(BigInteger value) {
            super(value);
        }

        @Override
        public ComputableNumber multiply(ComputableNumber number) {
            return new BigIntegerAdapter(((BigInteger) get()).multiply(((BigInteger) number.get())));
        }

        @Override
        public ComputableNumber add(ComputableNumber number) {
            return new BigIntegerAdapter(((BigInteger) get()).add(((BigInteger) number.get())));
        }
    }

    private static class LongAdapter extends ComputableNumber {

        private static final long serialVersionUID = 1L;

        private LongAdapter(long value) {
            super(value);
        }

        @Override
        public ComputableNumber multiply(ComputableNumber number) {
            return new LongAdapter(longValue() * number.longValue());
        }

        @Override
        public ComputableNumber add(ComputableNumber number) {
            return new LongAdapter(longValue() + number.longValue());
        }
    }
}
