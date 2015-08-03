package com.tasktoys.java8ws.hosoai.ch6.ex04;

import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;

public class UsageLongAccumulator {
	private static final int NUM_THREADS = 10;
	public static void main(String[] args) throws InterruptedException {
		FindMinMaxThread[] threadArray = new FindMinMaxThread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++) {
			threadArray[i] = new FindMinMaxThread(getLongRandomValues(10));
			threadArray[i].start();
		}
		for(FindMinMaxThread t : threadArray){
			t.join();
		}
		System.out.println("Maximum : "+FindMinMaxThread.getMaximum());
		System.out.println("Maximum : "+FindMinMaxThread.getMinimum());
		System.out.println(" used values");
		for(FindMinMaxThread t : threadArray){
			for(long l : t.values){
				System.out.println(" "+l);
			}
		}
	}
	public static long[] getLongRandomValues(int num){
		Random r = new Random(new Random().nextLong());
		return LongStream.iterate(0, a->r.nextLong()).limit(num).toArray();
	}
}

class FindMinMaxThread extends Thread{
	private static LongAccumulator getMaximum = new LongAccumulator((long a, long b)->a>b ? a:b, 0);
	private static LongAccumulator getMinimum = new LongAccumulator((long a, long b)->a<b ? a:b, 0);
	public long[] values;
	public FindMinMaxThread(long[] values){
		this.values = values;
	}
	
	@Override
	public void run() {
		for(long l : values){
			getMaximum.accumulate(l);
			getMinimum.accumulate(l);
		}
	}
	public static long getMaximum(){
		return getMaximum.get();
	}
	public static long getMinimum(){
		return getMinimum.get();
	}
}
