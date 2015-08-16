package com.tasktoys.java8ws.lagunapresa.ch6.ex09;

import java.util.Arrays;

public class Fibonacci {

    static final Matrix FIBONACCI_ID = new Matrix(new int[][]{{1, 1}, {1, 0}});

    private static final class Matrix {

        final int[][] value;

        Matrix(int[][] value) {
            this.value = value;
        }

        Matrix multiply(Matrix that) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int sum = 0;
                    for (int k = 0; k < 2; k++) {
                        sum += this.value[i][k] * that.value[k][j];
                    }
                    c[i][j] = sum;
                }
            }
            return new Matrix(c);
        }
    }

    public static long solve(int n) {
        if (n < 1) return 0;
        Matrix[] ms = new Matrix[n];
        Arrays.parallelSetAll(ms, i -> FIBONACCI_ID);
        Arrays.parallelPrefix(ms, Matrix::multiply);
        return ms[n - 1].value[1][0];
    }

    private Fibonacci() {
    }

}
