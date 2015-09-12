package com.tasktoys.java8ws.sato.ch8.ex05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println(count(Paths.get("./out/alice.txt")));
	}
	
	public static int count(Path path) {
		final int[] c = new int[1];
		try(Stream<String> lines = Files.lines(path)) {
			lines.map(str -> str.split(" "))
				.collect(Collectors.toList())
				.forEach(words -> {
					for (int i = 0; i < words.length; i++) {
						if (words[i].length() > 12) {
							c[0]++;
						}
					}
				});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c[0];
	}

}