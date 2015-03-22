package com.tasktoys.java8ws.intptr_t.ch2.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ch2Ex02 {	
	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));		
		
		// [0] := 合計呼び出し回数. [1] := フィルタにマッチした回数
		final int[] filterCalledCount = new int[]{0, 0};
		
		words.stream().filter( w -> {
			filterCalledCount[0]++;
			if(w.length() > 12){
				filterCalledCount[1]++;
				return true;
			} else {
				return false;
			}
		}).limit( 5 ).forEach(System.out::println);
		
		System.out.println();
		System.out.println("total count:" + filterCalledCount[0]);
		System.out.println("match count:" + filterCalledCount[1]);
	}
}
