package com.tasktoys.java8ws.intptr_t.ch9.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ch9Ex05 {
	static final Path FILE_PATH = Paths.get("./out/intptr_t-09-05.txt");
	
	public static void main(String[] args) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("./README.md"));

		Files.write(FILE_PATH, new byte[]{}, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		for( int i = bytes.length - 1; i >= 0; i--) {
			Files.write(FILE_PATH, new byte[]{bytes[i]}, StandardOpenOption.APPEND);
		}
	}
}
