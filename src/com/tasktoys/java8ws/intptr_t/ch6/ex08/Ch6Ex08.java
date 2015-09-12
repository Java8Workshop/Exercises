package com.tasktoys.java8ws.intptr_t.ch6.ex08;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

//
// 大体 97
// [48, 44, 82, 188, 73, 104, 87, 209, 110, 94, 102, 102, 73, 19, 52, 31, 79, 72, 36, 203, 235]
//
public class Ch6Ex08 {
	private static final int INIT_SIZE = 10;
	private static final int MAX_SAMPLE = 20;
	
	public static void main(String[] args) throws InterruptedException {
		int n = INIT_SIZE;
		Random rand = new Random(12345);
		List<Integer> totalN = new ArrayList<>();

		while(true){
			int[] aryBase = IntStream.generate(() -> rand.nextInt()).limit(n).toArray();
			int[] ary;
			Instant s1, e1, s2, e2;
			Duration d1, d2;

			// 並列版ソート
			ary = Arrays.copyOf(aryBase, aryBase.length);
			s1 = Instant.now();
			Arrays.parallelSort(ary);
			e1 = Instant.now();
			d1 = Duration.between(s1, e1);
			
			// 直列版ソート
			ary = Arrays.copyOf(aryBase, aryBase.length);
			s2 = Instant.now();
			Arrays.sort(ary);
			e2 = Instant.now();
			d2 = Duration.between(s2, e2);
			
			// 並列版ソートが直列版ソートより速くなったら、配列数を格納する
			if(d1.minus(d2).isNegative()) {				
				totalN.add(n);
				
				// 規定のサンプル数がたまったら、処理終了
				if(totalN.size() > MAX_SAMPLE){
					break;
				} else {
					// リソース初期化
					n = INIT_SIZE;
					System.gc();	// 念のためのリソース解放
					Thread.sleep(10); // 適当な休憩
				}
			} else {
				// 配列数を増やして、再度実行
				n++;
			}
		}
		
		System.out.println("大体 " + totalN.stream().mapToInt(i -> i).sum() / totalN.size() );
		System.out.println(totalN);
	}
}
