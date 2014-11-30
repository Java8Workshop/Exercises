package com.tasktoys.java8ws.mrbearing.ch9.ex01;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex01 {

  public Ex01() {
  }

  public static void main(String[] args) {
    System.out.println("test");
    
    
    
    try{
      Scanner in = new Scanner( Paths.get("./README.md") );
      PrintWriter out = new PrintWriter("./outMrBearing.txt");
      while(in.hasNext())
        out.println(in.next().toLowerCase());
      
      in.close();
      out.close();
      
    }catch(Exception e){
      
    }
    
  }

}
