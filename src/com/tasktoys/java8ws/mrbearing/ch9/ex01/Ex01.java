package com.tasktoys.java8ws.mrbearing.ch9.ex01;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 
 * @author MrBearing
 *
 */
public class Ex01 {

  public Ex01() {
  }

  public static void main(String[] args) {
    System.out.println("test");
     
    Scanner in = null;
    PrintWriter out = null;
    
    try{
      in = new Scanner( Paths.get("./README.md") );
      out = new PrintWriter("./out/MrBearing.txt");
      while(in.hasNext())
        out.println(in.next().toLowerCase());
      
      in.close();
      out.close();
      
    }catch(Exception e){
      e.printStackTrace();
      in.close();
      out.close();
    }
    
  }

}
