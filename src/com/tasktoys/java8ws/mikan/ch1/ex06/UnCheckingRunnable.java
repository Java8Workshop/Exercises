/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex06;

/**
 * @author mikan
 */
public class UnCheckingRunnable {

    @FunctionalInterface
    public interface RunnableEx {
        void run() throws Exception;
    }

    public static Runnable unCheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
