package com.tasktoys.java8ws.mrbearing.ch9.ex11;

import java.io.IOException;

public class CreditNumberSearcher {

  public CreditNumberSearcher() {
    // TODO 自動生成されたコンストラクター・スタブ
  }

  public static void main(String[] args) throws InterruptedException, IOException {
    ProcessBuilder bulider = new ProcessBuilder("dir"
        );
    bulider.inheritIO();
    bulider.start().waitFor();
    

  }

}
