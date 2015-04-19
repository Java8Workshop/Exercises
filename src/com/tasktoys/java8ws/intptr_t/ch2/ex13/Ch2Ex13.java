package com.tasktoys.java8ws.intptr_t.ch2.ex13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch2Ex13 {
	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("out/alice.txt")), StandardCharsets.UTF_8);
		List<String> wordsList = Arrays.asList(contents.split("[\\P{L}]+"));		
		Stream<String> words = wordsList.stream();
		
		int[] shortWords = calcWordCount2(words);
			
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
	
	static int[] calcWordCount2(Stream<String> words){		
		// 12文字未満の文字列のワードカウント
		//	1) 文字数を12文字未満でフィルタ
		// 	2-1) 文字列長をキーとして、グルーピングする
		//	2-2) 各グループについて個数を算出する
		Map<Integer,Long> lenAndCnt = words.parallel()
				.filter(s -> s.length() < 12)
				.collect(
					Collectors.groupingBy(
						s -> s.length(),
						Collectors.counting()));

		// Mapの順序が保証されているとは限らないため、文字列長のキーで結果を取得
		int[] result = new int[lenAndCnt.size()];
		for(Integer i = 0; i < lenAndCnt.size(); i++) {
			result[i.intValue()] = lenAndCnt.get(i).intValue();
		}
		return result;
	}	
}
