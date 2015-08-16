package com.tasktoys.java8ws.intptr_t.ch6.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Ch6Ex01 {
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("./out/alice.txt")), StandardCharsets.UTF_8);
		String[] words = contents.split("[\\P{L}]+");
		AtomicReference<String> maxLenOfStr = new AtomicReference<>("");
		
		Arrays.stream(words).parallel().forEach(word -> {
			maxLenOfStr.getAndUpdate(s -> word.length() > s.length() ? word : s);
		});

		System.out.println(maxLenOfStr.get().length() + " : " + maxLenOfStr.get());
	}
}
