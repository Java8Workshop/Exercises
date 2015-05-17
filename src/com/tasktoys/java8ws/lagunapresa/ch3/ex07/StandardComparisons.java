package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

public enum StandardComparisons implements Comparison {

    DESCENDING {
        @Override
        public Pair apply(Pair p) {
            return Pair.of(p.s2, p.s1);
        }
    },
    CASE_INSENSITIVE {
        @Override
        public Pair apply(Pair p) {
            return p.map(String::toLowerCase);
        }
    },
    WHITE_INSENSITIVE {
        @Override
        public Pair apply(Pair p) {
            return p.map(s -> s.replaceAll("\\s", ""));
        }
    },;

}
