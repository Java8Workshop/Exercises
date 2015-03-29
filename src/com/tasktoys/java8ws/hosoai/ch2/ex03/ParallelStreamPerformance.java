package com.tasktoys.java8ws.hosoai.ch2.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


/*
 * Parallel last.
 *  start Single Stream
 *  end Single Stream: 	164211
 *  start Parallel Stream
 *  end Parallel Stream: 446274
 * 
 * Parallel first.
 *  start Parallel Stream
 *  end Parallel Stream: 413007
 *  start Single Stream
 *  end Single Stream: 	99801
 */

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
		
		// break in
		instance.findLongWords(10);
		instance.findLongWords(10);
		instance.findLongWords(10);
		instance.findLongWords(10);
		instance.parallelFindLongWords(10);
		instance.parallelFindLongWords(10);
		instance.parallelFindLongWords(10);
		instance.parallelFindLongWords(10);
		
		System.out.println("start Parallel Stream");
		startTime = System.nanoTime();
		instance.parallelFindLongWords(10);
		System.out.println("end Parallel Stream: \t"+(System.nanoTime()-startTime));
		
		System.out.println("start Single Stream");
		startTime = System.nanoTime();
		instance.findLongWords(10);
		System.out.println("end Single Stream: \t"+(System.nanoTime()-startTime));

	}
}
