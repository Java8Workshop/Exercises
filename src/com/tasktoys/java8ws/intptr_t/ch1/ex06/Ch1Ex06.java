package com.tasktoys.java8ws.intptr_t.ch1.ex06;

import java.util.concurrent.Callable;

interface RunnableEx {
	public void run() throws Exception;
}

public class Ch1Ex06 {
	public static void main(String[] args) {
		new Thread(uncheck(()->{
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
		
		new Thread(uncheckCallable(() -> {
			System.out.println("Xxx");
			Thread.sleep(1000);
			return null; // Callable<T> must return any reference.
		})).start();
	}

	static Runnable uncheck(RunnableEx runner){
		return () -> {
			try {
				runner.run();
			} catch(Throwable t) {
				// kill them all exceptions!
			}
		};
	}

	static Runnable uncheckCallable(Callable<Void> caller){
		return () -> {
			try {
				caller.call();
			} catch(Throwable r) {
				// kill them all exceptions!
			}
		};
	}
}
