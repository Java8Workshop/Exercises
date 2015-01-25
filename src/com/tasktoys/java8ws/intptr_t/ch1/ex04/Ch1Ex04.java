package com.tasktoys.java8ws.intptr_t.ch1.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ch1Ex04 {
	public static void main(String[] args) {
		File file = new File("./");
		File[] files;
		
		files = file.listFiles();
	
		// sort directories -> file
		Arrays.sort(files, (a,b) -> {
			return a.isDirectory() ? -1 : 1;
		});
		int count = (int)Stream.of(files).filter(File::isDirectory).count();
		Arrays.sort(files,0,count);	// sort by directories.
		Arrays.sort(files,count,files.length); // sort by files.
		Stream.of(files).forEachOrdered(System.out::println);		
	}
}
