package com.tasktoys.java8ws.mrbearing.ch1.ex6;

public class Main {

  public static Runnable uncheck(RunnableEx runner){
    try{
      runner.run();
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return null;
  }

 
  interface RunnableEx {
    public void run()throws Exception;
  }
  
  public static void main(String[] args) {
    new Thread(uncheck(()->{
      System.out.println("Zzz");
      Thread.sleep(1000);
      throw new Exception("boo");
    })).start();
    
  }

}
