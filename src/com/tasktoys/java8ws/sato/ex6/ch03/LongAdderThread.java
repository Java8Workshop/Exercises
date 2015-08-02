package com.tasktoys.java8ws.sato.ex6.ch03;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderThread extends Thread {

	private LongAdder la;
	
	public LongAdderThread(LongAdder la) {
		this.la = la;
	}
	
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			la.increment();
		}
	}
}
