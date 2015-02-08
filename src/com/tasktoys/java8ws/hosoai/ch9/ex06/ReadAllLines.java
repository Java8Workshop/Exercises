package com.tasktoys.java8ws.hosoai.ch9.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReadAllLines {
	
	public void allReadLines(String inputFilePath, String outputFilePath){
		Path in = Paths.get(inputFilePath);
		Path out = Paths.get(outputFilePath);
		List<String> lines;
		try {
			lines = Files.readAllLines(in);
			Collections.reverse(lines);
			Files.write(out, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
