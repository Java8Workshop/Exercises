package com.tasktoys.java8ws.intptr_t.ch1.ex07;

public class Ch1Ex07 {
	public static void main(String[] args) {
		andThen(
			() -> { System.out.println("1"); },
			() -> { System.out.println("2"); }
		).run();
	}
	
	static Runnable andThen(Runnable r1, Runnable r2){
		return () -> {
			r1.run();
			r2.run();
		};
	}
}
