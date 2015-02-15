package com.tasktoys.java8ws.lagunapresa.ch1.ex07;

public class Combinator {

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> { first.run(); second.run(); };
    }

    public static void main(String[] args) throws Exception {
        new Thread(
                andThen(p("The chicken"), p(" or the egg"))
        ).start();
    }

    static Runnable p(String msg) {
        return () -> System.out.println(msg);
    }

}
