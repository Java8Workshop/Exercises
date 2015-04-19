package com.tasktoys.java8ws.intptr_t.ch2.ex12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch2Ex12 {
	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("out/alice.txt")), StandardCharsets.UTF_8);
		List<String> wordsList = Arrays.asList(contents.split("[\\P{L}]+"));		
		Stream<String> words = wordsList.stream();
		
		int[] shortWords = calcWordCount(words);

		//=============================
		// 検算
		//=============================
		// 検算用直列計算
		int[] shortWordsTest = new int[12];
		wordsList.stream().forEach(s -> {
			if(s.length() < 12) {
				shortWordsTest[s.length()]++;
			}
		});
		
		String[] result = new String[2];
		// 並列計算結果表示
		result[0] = Arrays.stream(shortWords)
				.mapToObj(s->String.valueOf(s))
				.collect(Collectors.joining(", "));
		System.out.println(result[0]);
		// 検算用、直列で計算した結果表示
		result[1] = Arrays.stream(shortWordsTest)
				.mapToObj(s->String.valueOf(s))
				.collect(Collectors.joining(", "));
		System.out.println(result[1]);
		
		System.out.println(result[0].equals(result[1]));
	}	
	
	static int[] calcWordCount(Stream<String> words){
		// 結果格納用配列を生成
		AtomicInteger[] shortWords = Stream
				.generate(() -> new AtomicInteger())
				.limit(12)
				.toArray(AtomicInteger[]::new);		

		// 並列計算
		words.parallel().forEach(s -> {
			if(s.length() < 12) {
				shortWords[s.length()].getAndIncrement();
			}
		});
		
		return Arrays.stream(shortWords).mapToInt(sw -> sw.get()).toArray();
	}
}
