package com.tasktoys.java8ws.intptr_t.ch2.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 整数とアイテムのペア
 *
 * @param <T> アイテムの型
 */
class IntPair<T> {
	private int	index;	// 要素番号
	private T 	item;	// アイテム
	
	public IntPair(int index, T item) {
		this.index = index;
		this.item = item;
	}
	
	public int getInt() {
		return this.index;
	}
	public T get() {
		return item;
	}
}

public class Ch2Ex01 {	
	private static long count = 0;
	private static Object countLock = new Object();
	
	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		// CPUの個数で分割する
		int splitCount = Runtime.getRuntime().availableProcessors();
		// 2つ以上になるよう、1以下の場合2にする。
		if( splitCount <= 1) {
			splitCount = 2;
		}
		// 分割時のサイズ、残りサイズを算出
		int p = words.size() / splitCount;
		int q = words.size() % splitCount;
		// 分割処理
		List<IntPair<List<String>>> wordsSegment = new ArrayList<>(splitCount);
		for(int i = 0; i < splitCount; i++) {
			wordsSegment.add( new IntPair<List<String>>(i, words.subList(i*p, i*p + p)));
		}
		wordsSegment.add( new IntPair<List<String>>(splitCount, words.subList(splitCount*p, splitCount*p + q)));

		//　各セグメントの合計個数格納先生成
		int[] counts = new int[wordsSegment.size()];

		// 個数を数えるスレッド生成
		Thread[] threads = wordsSegment.stream().map( idxlist -> {
			return new Thread(()->{
				for( String w : idxlist.get() ) {
					if( w.length() > 12 ) {
						counts[ idxlist.getInt() ]++;
					}
				}
			});
		} ).toArray(Thread[]::new);
		
		// スレッド始動！
		Arrays.stream(threads).forEach(Thread::start);

		// 数え上げる。(副作用どうにかしたいな)
		countup(threads, counts);
		System.out.println("thread:" + count);

		//=======================================
		// 確認
		// 合計値を収集
		count = Arrays.stream(counts).sum();
		System.out.println("stream:" + count);	
		// パラレスストリーム確認
		count = words.parallelStream().filter(w -> w.length() > 12).count();
		System.out.println("pstream:" + count);			
	}
	
	/**
	 * 各スレッドの処理が終了するごとに結果を合計する
	 * @param threads スレッド配列
	 */
	static void countup(Thread[] threads, int[] counts) {
		assert threads.length == counts.length;
		List<IntPair<Thread>> list = new ArrayList<>();
		for(int i = 0; i < threads.length; i++ ) {
			list.add(new IntPair<Thread>(counts[i], threads[i]));
		}
		
		// 各スレッドが終わるごとに加算
		list.parallelStream().forEach( item -> {
			try {
				item.get().join();
				synchronized(countLock) {
					count += item.getInt();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} );
	}
}
