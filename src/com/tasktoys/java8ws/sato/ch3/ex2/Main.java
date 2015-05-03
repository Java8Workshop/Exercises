package com.tasktoys.java8ws.sato.ch3.ex2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	static final Counter sharedCounter = new Counter();
	static final int count = 1000;
	static final int threadN = 100000;
	
	public static void main(String[] args) {
		Runnable r = () -> {
			int c = sharedCounter.getCount();
			for (int i = 0; i < count; i++) {
				c++;
			}
			sharedCounter.setCount(c);
		};
		System.out.println("Expected " + (count * threadN));
		
		System.out.println("With Lock");
		Lock l = new ReentrantLock();
		test(() -> {
			withLock(l, r);
		});
		
		System.out.println("Without Lock");
		test(() -> {
			withoutLock(r);
		});
	}
	
	static void test(Runnable r) {
		sharedCounter.setCount(0);
		Thread[] threads = new Thread[threadN];
		for (int i = 0; i < threadN; i++) {
			threads[i] = new Thread(r);
		}
		for (int i = 0; i < threadN; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threadN; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sharedCounter.getCount());
	}
	
	static void withLock(Lock lock, Runnable r) {
		lock.lock();
		try {
			r.run();
		} finally {
			lock.unlock();
		}
	}
	
	static void withoutLock(Runnable r) {
		r.run();
	}

	static private class Counter {
		
		int c;
		
		public Counter() {
			c = 0;
		}
		
		public void setCount(int count) {
			c = count;
		}
		
		public int getCount() {
			return c;
		}
	}
}
