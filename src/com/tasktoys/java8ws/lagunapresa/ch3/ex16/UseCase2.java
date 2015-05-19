package com.tasktoys.java8ws.lagunapresa.ch3.ex16;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UseCase2 {
    public static <T> void doInOrderAsync(Supplier<T> first,
                                          Consumer<Either<Throwable, T>> second) {
        Thread t = new Thread() {
            public void run() {
                try {
                    T result = first.get();
                    second.accept(Either.rightOf(result));
                } catch (Throwable t) {
                    second.accept(Either.leftOf(t));
                }
            }
        };
        t.start();
    }
}
