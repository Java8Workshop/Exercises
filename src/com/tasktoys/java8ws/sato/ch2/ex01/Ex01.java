package com.tasktoys.java8ws.sato.ch2.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.tasktoys.java8ws.sato.ch2.ex03.MyThread;

public class Ex01 {

	public static void main(String[] args) {
		List<String> words = getWords();
		long c1 = parallel(words);
		System.out.println(c1);
		long c2 = parallel(words);
		System.out.println(c2);
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
	
	public static long parallel(List<String> words) {
		int segment = words.size() / 100;
		int fromIndex = 0;
		int toIndex = segment;
		
		MyThread[] tarray = new MyThread[100];
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
		
		return total;
	}
	
	public static long nonParallel(List<String> words) {
		long c = 0;
		for(String s: words) {
			if (s.length() > 12) c++;
		}
		return c;
	}
}
