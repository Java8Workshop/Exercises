package com.tasktoys.java8ws.sato.ch2.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		List<String> words = getWords();
		System.out.println("parallel");
		long start = System.currentTimeMillis();
		long c = parallel(words);
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("count " + c);
		
		System.out.println("nonParallel");
		long start2 = System.currentTimeMillis();
		long c2 = nonParallel(words);
		System.out.println((System.currentTimeMillis() - start2) + "ms");
		System.out.println("count" + c2);
	}
	
	public static List<String> getWords() {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get("out/war_and_peace.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Arrays.asList(content.split("[\\P{L}]+"));
	}
	
	public static long parallel(List<String> words) {
		return words.parallelStream().filter(s -> s.length() > 12).count();
	}
	
	public static long nonParallel(List<String> words) {
		return words.stream().filter(s -> s.length() > 12).count();
	}

}
