package com.tasktoys.java8ws.lagunapresa.ch8.ex03;

public class Gcd {

    @FunctionalInterface
    public interface Remain {
        int apply(int i1, int i2);
    }

    public enum StandardRemain implements Remain {

        MOD {
            @Override
            public int apply(int i1, int i2) {
                return i1 % i2;
            }
        },

        FLOOR_MOD {
            @Override
            public int apply(int i1, int i2) {
                return Math.floorMod(i1, i2);
            }
        },

//        ORIGINAL {
//            @Override
//            public int apply(int i1, int i2) {
//                return;
//            }
//        }

    }

    public static int euclid(int a, int b, StandardRemain remain) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (b == 0) {
            return a;
        }
        return euclid(b, remain.apply(a, b), remain);
    }

}
