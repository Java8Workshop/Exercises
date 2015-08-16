package com.tasktoys.java8ws.intptr_t.ch6.ex07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ch6Ex07 {
	public static void main(String[] args) throws IOException {
		ConcurrentHashMap<String, Long> txtLength = new ConcurrentHashMap<>();
		
		String contents = new String(Files.readAllBytes(Paths.get("./out/alice.txt")), StandardCharsets.UTF_8);
		String[] words = contents.split("[\\P{L}]+");

		Arrays.stream(words).parallel().forEach(word -> {			
			txtLength.putIfAbsent(word, (long)word.length());
		});
		
		Map.Entry<String, Long> maxEntry = txtLength.reduceEntries(1, (e1, e2) -> {
			// chapter 6-1の結果と一致するように ">="にする。題意から">"でも問題無し
			return e1.getKey().length() >= e2.getKey().length() ? e1 : e2;
		});
		
		System.out.println(maxEntry.getKey() + " : " + maxEntry.getValue());
	}
}
