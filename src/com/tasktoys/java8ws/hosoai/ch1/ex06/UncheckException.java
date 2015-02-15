package com.tasktoys.java8ws.hosoai.ch1.ex06;



public class UncheckException {
	
	public void execute(){
		new Thread(uncheck(()->{
				System.out.println("Zzz"); Thread.sleep(1000);}));
	}
	
	public static Runnable uncheck(RunnableEx runner){
		try{
			runner.run();
		}catch(Exception e){
			
		}
		return null;
	}
		
	interface RunnableEx {
		public void run() throws Exception;
	}
}
