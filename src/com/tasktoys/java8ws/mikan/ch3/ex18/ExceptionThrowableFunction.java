/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex18;

/**
 * An exception throwable function.
 *
 * @author mikan
 */
@FunctionalInterface
public interface ExceptionThrowableFunction<T, R> {

    /**
     * Applies this function to the given argument or throws exception.
     *
     * @param t the function argument
     * @return the function result
     * @throws Exception if the exception thrown
     */
    R apply(T t) throws Exception;
}
