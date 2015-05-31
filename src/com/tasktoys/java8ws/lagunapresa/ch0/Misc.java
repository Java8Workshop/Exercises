package com.tasktoys.java8ws.lagunapresa.ch0;

import java.util.Arrays;
import java.util.List;

public class Misc {

    @SafeVarargs
    public static <E> List<E> List(E... es) {
        return Arrays.asList(es);
    }

    private Misc() {
    }

}
