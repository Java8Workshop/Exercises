package com.tasktoys.java8ws.lagunapresa.ch1.ex06;

import java.util.concurrent.Callable;

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

    static Callable<Void> getNothingReturns() {
        // Callable<Void> の #call メソッドのシグネチャは call : void ではなく call : java.lang.Void
        // つまり戻り値を持たないのではなく java.lang.Void のインスタンスか null を
        // 返さなくてはならない。（と思う）
        return null;
    }

}
