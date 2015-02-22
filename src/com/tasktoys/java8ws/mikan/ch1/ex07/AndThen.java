/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex07;

/**
 *
 * @author mikan
 */
public class AndThen {

    public static void main(String[] args) {
        new Thread(andThen(() -> {
            System.out.println("hoge");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }, () -> {
            System.out.println("fuga");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        })).start();
    }

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }

    public static Runnable andThenWithThread(Runnable run1, Runnable run2) {
        return () -> {
            Thread first = new Thread(run1);
            first.start();
            try {
                first.join();
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
            Thread second = new Thread(run2);
            second.start();
        };
    }
}
