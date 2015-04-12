package com.tasktoys.java8ws.intptr_t.ch2.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ch2Ex03 {
	/**
	 * stream  :1946 , 18717217ns(18ms)
	 * pstream1:1946 , 85595392ns(85ms)
	 * pstream2:1946 , 14286325ns(14ms)
	 */
	public static void main(String[] args) throws IOException {
		String contents = new String(
				//Files.readAllBytes(Paths.get("out/alice.txt")),
				Files.readAllBytes(Paths.get("out/2600.txt")),
				StandardCharsets.UTF_8);
		List<String> words1 = Arrays.asList(contents.split("[\\P{L}]+"));
		List<String> words2 = Arrays.asList(contents.split("[\\P{L}]+"));
		List<String> words3 = Arrays.asList(contents.split("[\\P{L}]+"));

		long begin, end, diff1, diff2, diff3;

		// パラレルストリームでカウントアップ
		// 1回目は遅い(?)
		begin = System.nanoTime();
		long parallelCount = words1.parallelStream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff2 = end - begin;

		// シーケンシャルなストリームのカウントアップ
		begin = System.nanoTime();
		long count = words2.stream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff1 = end - begin;

		// パラレルストリームでカウントアップ
		// 2回目は速い(?)
		begin = System.nanoTime();
		parallelCount = words3.parallelStream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff3 = end - begin;
		
		System.out.println( "stream  :" + count + " , " + diff1 + "ns(" + (diff1/1000/1000) + "ms)" );
		System.out.println( "pstream1:" + parallelCount + " , " + diff2 + "ns(" + (diff2/1000/1000) + "ms)" );
		System.out.println( "pstream2:" + parallelCount + " , " + diff3 + "ns(" + (diff3/1000/1000) + "ms)" );
	}
}
