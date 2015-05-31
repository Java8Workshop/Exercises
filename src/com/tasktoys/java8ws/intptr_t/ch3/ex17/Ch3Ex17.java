package com.tasktoys.java8ws.intptr_t.ch3.ex17;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.function.Consumer;

public class Ch3Ex17 {
	public static void main(String[] args) {
		Consumer<Throwable> handler = e -> {
			e.printStackTrace();
		};
		
		doInParallelAsync(() -> { 
			System.out.println("1-1");
		}, ()->{
			System.out.println("1-2");
		}, handler);
		
		doInParallelAsync(() -> { 
			System.out.println("2-1");
			throw new RuntimeException("thrown from 1");
		}, ()->{
			System.out.println("2-2");
		}, handler);

		doInParallelAsync(() -> { 
			System.out.println("3-1");
		}, ()->{
			System.out.println("3-2");
			throw new RuntimeException("thrown from 2");
		}, handler);

		doInParallelAsync(() -> { 
			System.out.println("4-1");
			throw new RuntimeException("thrown from 1");
		}, ()->{
			System.out.println("4-2");
			throw new RuntimeException("thrown from 2");
		}, handler);
	}
	
	/**
	 * firstとsecondを並列に実行する。
	 * どちらかのスレッドが例外をスローしたらhandlerを呼び出します。
	 * 両方のスレッドがスローした場合、2度handlerが呼び出されます。
	 * @param first
	 * @param second
	 * @param handler
	 */
	public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		Thread t1 = new Thread(first);
		Thread t2 = new Thread(second);
		UncaughtExceptionHandler uncaughtHandler = (Thread th, Throwable e) -> {
			handler.accept(e);
		};
		
		t1.setUncaughtExceptionHandler(uncaughtHandler);
		t2.setUncaughtExceptionHandler(uncaughtHandler);
		
		t1.start();
		t2.start();
	}
}
