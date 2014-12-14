package com.tasktoys.java8ws.intptr_t.ch9.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Ch9Ex06 {
	static final Path FILE_PATH = Paths.get("./out/intptr_t-09-06.txt");
	
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("./README.md"));

		Files.write(FILE_PATH, new byte[]{}, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		for(int i = lines.size() - 1; i >= 0; i--) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(lines.get(i)).append("\n");

			Files.write(FILE_PATH, buffer.toString().getBytes(), StandardOpenOption.APPEND);
		}
	}
}
