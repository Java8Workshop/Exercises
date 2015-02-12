package com.tasktoys.java8ws.intptr_t.ch1.ex07;

public class Ch1Ex07 {
	public static void main(String[] args) {
		addThen(
			() -> { System.out.println("1"); },
			() -> { System.out.println("2"); }
		).run();
	}
	
	static Runnable addThen(Runnable r1, Runnable r2){
		return () -> {
			r1.run();
			r2.run();
		};
	}
}
