package com.tasktoys.java8ws.sato.ch2.ex03;

import java.util.List;

public class MyThread extends Thread {
		
	private List<String> words;
	boolean fin;
	long result;
	
	public MyThread(List<String> words) {
		this.words = words;
		fin = false;
		result = 0;
	}
		
	@Override
	public void run() {
		result = words.stream().filter(s -> s.length() > 12).count();
		fin = true;
	}
		
	synchronized public long getResult() {
		while (!fin) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
