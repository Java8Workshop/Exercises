package com.tasktoys.java8ws.sato.ch9.ex06;

import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadLineReverse {

	public static void main(String[] args) {
		Path path = Paths.get("./README.md");
		Path outputPath = Paths.get("./out/ch9ex06out.txt");
		try {
			List<String> lines = Files.readAllLines(path);
			List<String> rev = new LinkedList<>();
			for (String line: lines) {
				rev.add(0, line);
			}
			Files.write(outputPath, rev);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
