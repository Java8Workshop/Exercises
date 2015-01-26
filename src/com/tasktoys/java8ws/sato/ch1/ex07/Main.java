package com.tasktoys.java8ws.sato.ch1.ex07;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Runnable r1 = () -> {
			System.out.print(Thread.currentThread().getName());
			System.out.println(" first");
			};
		Runnable r2 = () -> {
			System.out.print(Thread.currentThread().getName());
			System.out.println(" second");
			};
		Thread thread1 = new Thread(andThen(r1, r2));
		thread1.start();
		thread1.join();
		(new Thread(andThen(r2, r1))).start();
	}
	
	public static Runnable andThen(Runnable r1, Runnable r2) {
		return () -> { r1.run(); r2.run(); };
	}

}
