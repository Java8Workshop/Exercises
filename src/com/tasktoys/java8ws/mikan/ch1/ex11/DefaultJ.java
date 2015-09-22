/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex11;

/**
 * @author mikan
 */
public interface DefaultJ {
    default void f() {
        System.out.println("DefaultJ.f()");
    }
}