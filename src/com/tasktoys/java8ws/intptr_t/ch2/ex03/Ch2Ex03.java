package com.tasktoys.java8ws.intptr_t.ch2.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ch2Ex03 {

	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("out/alice.txt")),
				//Files.readAllBytes(Paths.get("2600.txt")),
				StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));		

		long begin, end, diff1, diff2;
		
		// シーケンシャルなストリームのカウントアップ
		begin = System.nanoTime();
		long count = words.stream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff1 = end - begin;

		// パラレルストリームでカウントアップ
		begin = System.nanoTime();
		long parallelCount = words.parallelStream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff2 = end - begin;

		System.out.println( "stream  :" + count + " , " + diff1 + "ns(" + (diff1/1000/1000) + "ms)" );
		System.out.println( "pstream :" + parallelCount + " , " + diff2 + "ns(" + (diff2/1000/1000) + "ms)" );
	}
}
