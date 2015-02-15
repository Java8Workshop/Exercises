package com.tasktoys.java8ws.lagunapresa.ch1.ex07;

import static com.tasktoys.java8ws.lagunapresa.ch1.ex07.Combinator.p;

// andThen メソッド、ほんとはこんな感じになってほしい
public interface RichRunnable extends Runnable {

    default Runnable andThen(Runnable then) {
        return () -> {
            this.run();
            then.run();
        };
    }

    public static void main(String[] args) throws Exception {
        new Thread(
                RichRunnable.of(p("The chicken")).andThen(p(" or the egg"))
        ).start();
    }

    static RichRunnable of(Runnable r) {
        return r::run;
    }

}
