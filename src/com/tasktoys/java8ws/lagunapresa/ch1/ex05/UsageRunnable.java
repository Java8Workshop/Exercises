package com.tasktoys.java8ws.lagunapresa.ch1.ex05;

public class UsageRunnable {

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                doSomethingWonderful("A HAPPY NEW YEAR!!");
            }

            private void doSomethingWonderful(String msg) {
                System.out.println(msg);
            }

        }).start();
    }

}
