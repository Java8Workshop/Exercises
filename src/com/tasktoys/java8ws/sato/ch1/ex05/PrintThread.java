package com.tasktoys.java8ws.sato.ch1.ex05;

public class PrintThread implements Runnable {

	public void run() {
		while(true) {
			System.out.println(Thread.currentThread());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
