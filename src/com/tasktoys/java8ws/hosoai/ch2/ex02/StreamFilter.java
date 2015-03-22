package com.tasktoys.java8ws.hosoai.ch2.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilter {
	int length;
	public static void main(String[] args) {
		for(String word : new StreamFilter().findLongWords(5)){
			System.out.println(word);
		}
	}
	public String[] findLongWords(int length) {		
		this.length=length;
		String[] result = null;
		try {
			String contents = new String(Files.readAllBytes(Paths.get("out/alice.txt")),StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			
			Stream<String> wordStream = words.stream();
			result = wordStream.filter(this::myFilter).peek(p->System.out.println(p)).limit(5).toArray(String[]::new);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean myFilter(String s){
		boolean result = s.length()>this.length;
		System.out.println(result+" : call filter : "+s);
		return result;
	}
}
