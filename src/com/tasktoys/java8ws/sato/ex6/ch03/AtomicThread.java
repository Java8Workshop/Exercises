package com.tasktoys.java8ws.sato.ex6.ch03;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicThread extends Thread {

	private AtomicLong al;
	
	public AtomicThread(AtomicLong al) {
		this.al = al;
	}
	
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			al.incrementAndGet();
		}
	}
}
