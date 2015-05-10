package com.tasktoys.java8ws.sato.ch3.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class MyFuture<T, U> implements Future<U> {

	Future<T> fu;
	Function<T, U> f;
	
	public MyFuture(Future<T> fu, Function<T, U> f) {
		this.fu = fu;
		this.f = f;
	}
		
	@Override
	public boolean cancel(boolean arg0) {
		return fu.cancel(arg0);
	}

	@Override
	public U get() throws InterruptedException, ExecutionException {
		return f.apply(fu.get());
	}

	@Override
	public U get(long arg0, TimeUnit arg1) throws InterruptedException,
			ExecutionException, TimeoutException {
		return f.apply(fu.get(arg0, arg1));
	}
	
	@Override
	public boolean isCancelled() {
		return fu.isCancelled();
	}

	@Override
	public boolean isDone() {
		return fu.isDone();
	}
}
