package com.tasktoys.java8ws.lagunapresa.ch1.ex06;

@FunctionalInterface
public interface RunnableEx {

    void run() throws Throwable;

    static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    static void main(String[] args) {
        new Thread(uncheck(() ->
        {
            System.out.println("Zzz");
            Thread.sleep(1000L);
        })).start();
        // catch 必要なし
    }

}
