package com.tasktoys.java8ws.mrbearing.ch1.ex06;

public class Main {

  public static Runnable uncheck(RunnableEx runner){
    return () -> {
      try{
        runner.run();
      }catch(Exception e){
        e.printStackTrace();
      }
    };
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
    System.out.println("Nuuuu");
  }

}
