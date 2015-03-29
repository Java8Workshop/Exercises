package com.tasktoys.java8ws.hosoai.ch2.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamPerformance {
	List<String> words = null;
	
	public ParallelStreamPerformance(){
		String contents;
		try {
			contents = new String(Files.readAllBytes(Paths.get("out/alice.txt")),StandardCharsets.UTF_8);
			words = Arrays.asList(contents.split("[\\P{L}]+"));		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] findLongWords(int length){
		return words.stream().filter(w->w.length()>length).limit(5).toArray(String[]::new);	
	}
	
	public String[] parallelFindLongWords(int length){
		return words.parallelStream().filter(w->w.length()>length).limit(5).toArray(String[]::new);			
	}
	
	public static void main(String[] args) {
		ParallelStreamPerformance instance = new ParallelStreamPerformance();
		long startTime = System.nanoTime();
		System.out.println("start Single Stream");
		instance.findLongWords(10);
		System.out.println("ennd Single Stream: \t"+(System.nanoTime()-startTime));
		startTime = System.nanoTime();
		System.out.println("start Parallel Stream");
		instance.parallelFindLongWords(10);
		System.out.println("ennd Parallel Stream: \t"+(System.nanoTime()-startTime));
	}
}
