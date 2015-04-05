package com.tasktoys.java8ws.lagunapresa.ch2.ex02;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class TakeFive {

    public List<String> take5WithSideEffect(int length, List<String> words, IntConsumer sideEffect) {
        return words.stream()
                .filter(w -> {
                    sideEffect.accept(length);
                    return w.length() > length;
                })
                .limit(5)
                .collect(Collectors.toList());
    }

}
