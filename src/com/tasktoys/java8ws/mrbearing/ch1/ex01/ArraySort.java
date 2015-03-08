package com.tasktoys.java8ws.mrbearing.ch1.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArraySort {

  public static void main(String[] args) {
    Thread th = new Thread(new Runnable() {
      
      @Override
      public void run() {
        Random random = new Random(System.currentTimeMillis());
        
        List<Integer> list = new ArrayList<>();
        
        for(int i =0; i < 100 ; i++){
          list.add( random.nextInt() );
        }
        
        list.forEach(System.out::println);
        
        Arrays.sort( list.toArray(), (first, second)->{
          String threadName =Thread.currentThread().getName();
          System.out.println(threadName);
          return Integer.compare((Integer) first, (Integer)second);
        });
      }
    });
    th.setName("daihyo");
    th.start();
  }

}
