package com.tasktoys.java8ws.lagunapresa.ch9.ex06;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLines {

	public static void main(String[] arg) throws Exception {
		List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("README.md")));
		Collections.reverse(lines);
		Files.write(Paths.get("out/out.txt"), lines);
	}

}
