/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch8.ex14;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Created by mikan on 2015/11/10.
 *
 * @author mikan
 */
public class NonNullMethod {

    public static void print(String str) {
        Objects.requireNonNull(str, createNullMessageWithInvoker("str"));
        System.out.println(str);
    }

    public static void main(String[] args) {
        print("non-null");
        try {
            print(null);
        } catch (NullPointerException e) {
            System.out.println("NPE: " + e.getMessage());
        }
    }

    private static Supplier<String> createNullMessageWithInvoker(String paramName) {
        return () -> {
            StackTraceElement[] elements = new RuntimeException().getStackTrace();
            StackTraceElement invoker = elements[4]; // lambda <- createNMWI() <- print() <- invoker
            return paramName + " is null, invoked from " + invoker.getClassName() + "." + invoker.getMethodName();
        };
    }
}
