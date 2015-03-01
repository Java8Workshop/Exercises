package com.tasktoys.java8ws.lagunapresa.ch1.ex09;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Collection2Test {

    private static final List<String> SRC = Arrays.asList(
            "安心",
            "苦悩",
            "心配",
            "盲信");

    private static final Collection2<String> DATA = new Collection2.ArrayList2<>();

    static {
        DATA.addAll(SRC);
    }

    @Test
    public void testSort() {
        // 目視
        DATA.forEachIf(this::pyonpyon, s -> s.contains("心"));
    }

    private void pyonpyon(String s) {
        System.out.println(s.replaceAll("心", "心ぴょんぴょん"));
    }

}
