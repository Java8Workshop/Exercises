package com.tasktoys.java8ws.intptr_t.ch8.ex08;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class Ch8Ex08 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Queue<Long> safeBaseQue = new ArrayDeque<>();
		Queue<Long> unsafeBaseQue = new ArrayDeque<>();

		@SuppressWarnings("rawtypes") Queue safeQue = Collections.checkedQueue(safeBaseQue, Long.class);
		@SuppressWarnings("rawtypes") Queue unsafeQue = unsafeBaseQue;
		
		//
		// Unchecked Queue
		//
		try {
			unsafeQue.add(1);	// 追加できてしまう
		} catch(Exception ex) {
			System.out.println("ここは通らない");
		}

		// 要素の型が正しくないので、このような使い方はできない
		//unsafeBaseQue.forEach(System.out::println);
		
		// Long -> Integerへの直接キャストはできないので1回Objectを経由する
		// キャストが必要であり安全ではない
		for(Object obj : unsafeBaseQue) {
			System.out.println(((Integer)obj) * 2);
		}
		
		try {
			Long v = unsafeBaseQue.peek();
			System.out.println("ここは通らない" + v);
		} catch(Exception ex) {
			System.out.println("Type of element is not Long: ");
			System.out.println(ex);
		}
		
		//
		// Checked Queue
		//
		try {
			safeQue.add(2L); // OK
			safeQue.add(20); // NG
		} catch(Exception ex) {
			System.out.println("Integer cannot insert to List<Long>: ");
			System.out.println(ex);
		}
		// checkedQueueで生成したインスタンスを経由して要素を追加すれば、要素が必ず要素がLongである事が保証される
		safeBaseQue.stream().map(v -> v*2).forEach(System.out::println);
	}
}
