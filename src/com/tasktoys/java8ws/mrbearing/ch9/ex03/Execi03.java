package com.tasktoys.java8ws.mrbearing.ch9.ex03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class Execi03 {

  public Execi03() {
    // TODO 自動生成されたコンストラクター・スタブ
  }

  
  public void process(int i) throws IOException //FileNotFoundException , UnknownHostException
  {
    
    try {
      if(i==0) 
        throw new FileNotFoundException();
      else 
        throw new UnknownHostException();
      
    }catch (FileNotFoundException | UnknownHostException ex){
      throw ex;
    }
  }
}
