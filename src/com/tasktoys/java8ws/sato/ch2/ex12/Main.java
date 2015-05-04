package com.tasktoys.java8ws.sato.ch2.ex12;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.tasktoys.java8ws.sato.ch2.ex01.Ex01;

public class Main {

	public static void main(String[] args) {
		List<String> words = Ex01.getWords();
		
		System.out.println("non parallel");
		int[] shortWords = new int[12];
		for (int i = 0; i < shortWords.length; i++) {
			shortWords[i] = 0;
		}
		words.stream().forEach(s -> {
			if (s.length() < 12) shortWords[s.length()]++;
		});
		for (int i = 0; i < shortWords.length; i++) {
			System.out.println("length " + i + " " + shortWords[i]);
		}

		System.out.println("parallel");
		AtomicInteger[] shortWords2 = new AtomicInteger[12];
		for (int i = 0; i < shortWords2.length; i++) {
			shortWords2[i] = new AtomicInteger(0);
		}
		words.stream().parallel().forEach(s -> {
			if (s.length() < 12) shortWords2[s.length()].getAndIncrement();
		});
		for (int i = 0; i < shortWords2.length; i++) {
			System.out.println("length " + i + " " + shortWords2[i].get());
		}
	}

}
