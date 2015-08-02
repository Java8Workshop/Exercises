package com.tasktoys.java8ws.sato.ex6.ch04;

import java.util.concurrent.atomic.LongAccumulator;

public class WorkingThread extends Thread {

	LongAccumulator la;
	long start;
	long end;
	
	public WorkingThread(LongAccumulator la, long start, long end) {
		this.la = la;
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		for (long l = start; l <= end; l++) {
			la.accumulate(l);
		}
	}
}
