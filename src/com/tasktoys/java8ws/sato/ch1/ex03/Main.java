package com.tasktoys.java8ws.sato.ch1.ex03;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<File> files = getFilesWithExtension(new File("."), "md");
		files.forEach(System.out::println);
	}

	public static List<File> getFilesWithExtension(File file, String extension) {
		if (file.isDirectory())
			return Stream.of(file.list((f, str) -> str.endsWith("." + extension)))
					.map(str -> new File(str))
					.collect(Collectors.toList());
		else
			return new LinkedList<File>();
	}
}
