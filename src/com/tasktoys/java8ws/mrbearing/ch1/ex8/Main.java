package com.tasktoys.java8ws.mrbearing.ch1.ex8;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    
    String[] names ={
      "peter","paul","marry"  
    };
    
    List<Runnable> runners = new ArrayList<>();
    for(String name: names)
      runners.add(() -> System.out.println(name));
    
    for(Runnable r: runners)
      r.run();
    System.out.println("********");
    
    List<Runnable> runners2 = new ArrayList<>();
    
    for(int i= 0; i<names.length ;i++){
      String name = names[i];
      runners2.add(()->System.out.println(name));
    }
    
    
    for(Runnable r: runners2)
      r.run();
  }

}
