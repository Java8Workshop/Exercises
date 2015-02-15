/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex06;

/**
 *
 * @author mikan
 */
public class UncheckingThread {

    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }
    
    public interface RunnableEx {
        public void run() throws Exception;
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
