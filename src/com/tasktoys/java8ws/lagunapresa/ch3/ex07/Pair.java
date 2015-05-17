package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

import java.util.function.Function;

class Pair {

    final String s1;
    final String s2;

    static Pair of(String s1, String s2) {
        return new Pair(s1, s2);
    }

    Pair(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    Pair map(Function<String, String> f) {
        return of(f.apply(s1), f.apply(s2));
    }

}
