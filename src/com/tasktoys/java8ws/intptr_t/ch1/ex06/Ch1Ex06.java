package com.tasktoys.java8ws.intptr_t.ch1.ex06;

interface RunnableEx {
	public void run() throws Exception;
}

public class Ch1Ex06 {
	public static void main(String[] args) {
		new Thread(uncheck(()->{
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
	}

	static Runnable uncheck(RunnableEx runner){
		return () -> {
			try {
				runner.run();
			} catch(Throwable t) {
				// kill them all exceptions!
			}
		};
	}
}
