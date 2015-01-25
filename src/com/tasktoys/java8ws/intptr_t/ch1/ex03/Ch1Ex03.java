package com.tasktoys.java8ws.intptr_t.ch1.ex03;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Ch1Ex03 {
	public static void main(String[] args) {		
		File file = new File("./out");
		String suffix = ".txt"; // enclosure

		// make test file
		try {
			Files.write(Paths.get( file.getPath() + "/intptr_t-01-03" + suffix ), new byte[]{}, StandardOpenOption.CREATE_NEW);
		} catch(Throwable e) {
			// kill them all exception!
		}
		
		// study code
		String[] files = file.list( (dir,name)->{
			return new File(dir.getAbsolutePath() + File.separator + name).isFile() && name.endsWith(suffix);
		} );

		if(files != null && files.length != 0) {
			Stream.of(files).forEach(System.out::println);
		} else {
			System.out.println("none!");
		}
	}
}
