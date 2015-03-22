package com.tasktoys.java8ws.mrbearing.ch1.ex07;

public class Main {

  public static Runnable andThen(Runnable runner1,Runnable runner2){
    runner1.run();
    return runner2;
    
  }
  
  public static void main(String[] args) {
    andThen(()-> {
      System.out.println("runnner1 hi!");
    }, ()->{
      System.out.println("runnner2 hi!");
    }).run();
    }

  }


