package com.tasktoys.java8ws.intptr_t.ch8.ex14;

import java.util.Objects;

public class Ch8Ex14 {

	public static void main(String[] args) {
		test(() -> { System.out.println("run"); });
		test(null);
	}
	
	static void test(Runnable runner) {
		Objects.requireNonNull(runner, "nullです").run();
	}
}
