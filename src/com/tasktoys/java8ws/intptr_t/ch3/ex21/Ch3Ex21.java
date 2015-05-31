package com.tasktoys.java8ws.intptr_t.ch3.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Ch3Ex21 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {		
		ExecutorService exec = Executors.newFixedThreadPool(1);
		FutureTask<Integer> future = new FutureTask<Integer>(() -> {
			Thread.sleep(1000);
			return 1;
		});
		
		exec.execute(future);
		Future<String> result = map(future, i -> String.valueOf(i * 2) + "です。");
		exec.shutdown();
		
		System.out.println(result.get());
	}
	
	static <T, U> Future<U> map(Future<T> future, Function<T, U> f) 
			throws InterruptedException, ExecutionException {				
		return new Future<U>() {
			boolean canceled = false;
			
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return true;
			}

			@Override
			public boolean isCancelled() {
				return canceled;
			}

			@Override
			public boolean isDone() {
				return true;
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return f.apply(future.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException,
					TimeoutException {
				return get();
			}			
		};
	}
}
