package com.tasktoys.java8ws.mrbearing.ch3.ex21;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Ch3Ex21 {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		Future<String> stringfuture = CompletableFuture.supplyAsync(()->"this is test.");
		Future<Integer> mapped = map(stringfuture,(String s)->s.length());
		System.out.println("src:"+stringfuture.get());
		System.out.println("result:"+mapped.get());
	}

	public static<T,U> Future<U> map(Future<T> future, Function <T,U> mapperFanction){
		return new Future<U>() {
/*
			private boolean isDoneFlag = false;
			private U returnU = null;
			private Thread fanctionExecuteThread = new Thread(()->{
				try{
					returnU = fanction.apply(future.get());
				}catch (Exception e) {
					// TODO: handle exception
					throw e;
				}
			});
*/
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return future.cancel(mayInterruptIfRunning);
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return mapperFanction.apply(future.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException,
					TimeoutException {
				return mapperFanction.apply(future.get());
			}

			@Override
			public boolean isCancelled() {
				return future.isCancelled();
			}

			@Override
			public boolean isDone() {
				return future.isDone();
			}

		};
	}

}
