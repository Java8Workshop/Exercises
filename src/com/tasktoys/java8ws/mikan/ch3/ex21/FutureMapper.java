/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex21;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

/**
 * @author mikan
 */
public class FutureMapper {

    private FutureMapper() {
        // static use only
    }

    public static <T, U> Future<U> map(Future<T> future, Function<T, U> mapper) {
        Objects.requireNonNull(future);
        Objects.requireNonNull(mapper);
        return new Future<U>() {

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return future.cancel(mayInterruptIfRunning);
            }

            @Override
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override
            public boolean isDone() {
                return future.isDone();
            }

            @Override
            public U get() throws InterruptedException, ExecutionException {
                return mapper.apply(future.get());
            }

            @Override
            public U get(long timeout, TimeUnit unit)
                    throws InterruptedException, ExecutionException, TimeoutException {
                return mapper.apply(future.get(timeout, unit));
            }
        };
    }
}
