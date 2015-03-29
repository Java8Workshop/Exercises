package com.tasktoys.java8ws.sato.ch2.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ex03 {

	/*
	 * exp2
	 * parallel
	 * 2ms
	 * count 1946
	 * nonParallel
	 * 3ms
	 * count 1946
	 * by Thread
	 * 20ms
	 * count 1946
	 * 
	 */
	
	public static void main(String[] args) {
		List<String> words = getWords();
		System.out.println("parallel");
		parallel(words);
		
		System.out.println("nonParallel");
		nonParallel(words);
		
		System.out.println("by Thread");
		thread(words);
		
		System.out.println("\nexp2");
		System.out.println("parallel");
		parallel(words);
		
		System.out.println("nonParallel");
		nonParallel(words);
		
		System.out.println("by Thread");
		thread(words);
	}
	
	public static List<String> getWords() {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get("out/pg2600.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Arrays.asList(content.split("[\\P{L}]+"));
	}
	
	public static void parallel(List<String> words) {
		long start = System.currentTimeMillis();
		long c = words.parallelStream().filter(s -> s.length() > 12).count();
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("count " + c);
	}
	
	public static void nonParallel(List<String> words) {
		long start = System.currentTimeMillis();
		long c = words.stream().filter(s -> s.length() > 12).count();
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("count " + c);
	}

	public static void thread(List<String> words) {
		long start = System.currentTimeMillis();
		
		int segment = words.size() / 100;
		int fromIndex = 0;
		int toIndex = segment;
		
		MyThread[] tarray = new MyThread[101];
		for (int i = 0; i < 100; i++) {
			tarray[i] = new MyThread(words.subList(fromIndex, toIndex));
			tarray[i].start();
			fromIndex += segment;
			toIndex += segment;
		}
		MyThread last = new MyThread(words.subList(fromIndex, words.size()));
		last.start();
		
		long total = 0;
		for (int i = 0; i < 100; i++) {
			total += tarray[i].getResult();
		}
		total += last.getResult();
		
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("count " + total);
	}
}
