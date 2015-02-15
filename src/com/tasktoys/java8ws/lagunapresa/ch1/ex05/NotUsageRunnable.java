package com.tasktoys.java8ws.lagunapresa.ch1.ex05;

public class NotUsageRunnable {

    public static void main(String[] args) {
        new Thread(() -> doSomethingWonderful("A HAPPY NEW YEAR!!")).start();
    }

    private static void doSomethingWonderful(String msg) {
        System.out.println(msg);
    }

}
// Decreased 7 lines ! Wow !