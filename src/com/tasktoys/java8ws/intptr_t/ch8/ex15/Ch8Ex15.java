package com.tasktoys.java8ws.intptr_t.ch8.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Ch8Ex15 {
	public static void main(String[] args) throws IOException {		
		Files.lines(Paths.get("./out/alice.txt"))
			.filter(Pattern.compile("^a.*s$").asPredicate())
			.forEach(System.out::println);
	}
}
