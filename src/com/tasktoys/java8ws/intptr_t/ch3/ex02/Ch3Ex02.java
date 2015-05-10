package com.tasktoys.java8ws.intptr_t.ch3.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class Ch3Ex02 {
	public static void main(String[] args) {
		ReentrantLock myLock = new ReentrantLock();
		withLock(myLock, () -> { System.out.println("something doing.");} );
	}
	
	public static void withLock(ReentrantLock myLock, Runnable action) {
		myLock.lock();
		try {
			action.run();
		} finally {
			myLock.unlock();
		}
	}
}
