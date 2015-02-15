package com.tasktoys.java8ws.sato.ch1.ex06;

public class Main {

	public static void main(String[] args) {
		new Thread(uncheck(() -> {
			System.out.println("hoge");
			Thread.sleep(1000);
			System.out.println("hoge2");
			})).start();

	}

	public interface RunableEx {
		void run() throws Exception;
	}
	
	public static Runnable uncheck(RunableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		};
	}
}
