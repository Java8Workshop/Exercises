package com.tasktoys.java8ws.intptr_t.ch3.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Ch3Ex16 {
	public static void main(String[] args) throws InterruptedException {
		Supplier<Integer> okFunc1 = () -> 1 + 1;
		Supplier<Integer> ngFunc1 = () -> 1 / 0;

		// 例外を握りつぶし完結させる場合。
		BiConsumer<Integer, Throwable> okFunc2 = (value, th) -> {
			if(value != null) {
				System.out.println(value);
			}
			if(th != null) {
				System.out.println(th.getMessage());
			}
		};
		// 答えが例外が出る場合に、ハンドラに処理させる場合。
		BiConsumer<Integer, Throwable> ngFunc2 = (value, th) -> {
			if(value != null) {
				System.out.println(value);
			}
			if(th != null) {
				throw new RuntimeException(th);
			}
		};
		// 絶対例外を投げる！
		BiConsumer<Integer, Throwable> exFunc2 = (value, th) -> {
			throw new RuntimeException("絶対例外を投げる！");
		};
		Consumer<Throwable> handler = (th) -> {
			System.out.println(th.getMessage() + " 致命的な例外が発生しました。プログラムを終了します。");
		};

		System.out.println("OK:");
		doInOrderAsync(okFunc1, okFunc2, handler);
		Thread.sleep(1000);
		System.out.println();
		
		System.out.println("1つ目で例外");
		doInOrderAsync(ngFunc1, okFunc2, handler);
		Thread.sleep(1000);
		System.out.println();
		
		System.out.println("2つ目で例外");
		doInOrderAsync(okFunc1, exFunc2, handler);
		Thread.sleep(1000);
		System.out.println();
		
		System.out.println("例外をチェーン");
		doInOrderAsync(ngFunc1, ngFunc2, handler);
		Thread.sleep(1000);
		System.out.println();
	}
	
	// Q.3つめのパラメータは必要ですか？
	// A.2つめのパラメータで例外が出た時、通知する必要があるので必要
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second, Consumer<Throwable> handler) {
		Thread t = new Thread() {
			@Override
			public void run() {
				T result1st = null;
				Throwable th = null;
				try {
					result1st = first.get();
				} catch(Throwable e) {
					th = e;
				} finally {
					try {
						second.accept(result1st, th);
					} catch(Throwable e) {
						handler.accept(e);
					}
				}
			}
		};
		t.start();
	}
}
