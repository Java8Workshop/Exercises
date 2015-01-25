package com.tasktoys.java8ws.intptr_t.ch1.ex02;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ch1Ex02 {
	public static void main(String[] args) {
		File file = new File("./");
		File[] dirs1, dirs2;
		
		// lambda version
		System.out.println("lambda:");
		dirs1 = file.listFiles( name -> name.isDirectory() );
		Stream.of(dirs1).forEach(System.out::println);
		
		// method reference
		System.out.println("method reference:");
		dirs2 = file.listFiles(File::isDirectory);
		Stream.of(dirs2).forEach(System.out::println);
		
		// check matching all
		boolean match = true;
		for( File dir1 : dirs1 ) {
			match &= Arrays.asList(dirs2).contains(dir1);
			if(!match){ break; }
		}
		System.out.println("match?: " + match);
	}
}
