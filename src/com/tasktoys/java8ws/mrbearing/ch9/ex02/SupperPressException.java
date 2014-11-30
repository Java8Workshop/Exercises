package com.tasktoys.java8ws.mrbearing.ch9.ex02;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 * Javaプログラマーなら習得しておきたい Java SE 8 実践プログラム
 * 第9章 練習問題1
 * @author MrBearing
 */

public class SupperPressException {

  public SupperPressException() {  }

  public static void main(String[] args) throws Exception {
    Scanner in = null;
    PrintWriter out = null;
    IOException ie = null;
        
    try{
      
      in = new Scanner( Paths.get("./README.md") );
      out = new PrintWriter("./out/MrBearing.txt");
      
      while(in.hasNext()){
        String line = in.next().toLowerCase();
        out.println(line);
        System.out.println(line);
      }
      
    }catch(IOException e){
      
      e.printStackTrace();
      ie = e;
      throw ie;
      
    } finally{
      safeClose(out, ie);
      safeClose(in , ie);
    }
  }
  
  
  private static void safeClose(Closeable res ,Exception supper_e) {
    try {
      if (res != null) {
        res.close();
      }
    } catch (IOException e) {
      if(supper_e != null)
        supper_e.addSuppressed(e);
    }
  }
  

}
