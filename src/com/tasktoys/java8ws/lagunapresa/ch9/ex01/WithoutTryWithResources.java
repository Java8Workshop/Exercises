package com.tasktoys.java8ws.lagunapresa.ch9.ex01;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class WithoutTryWithResources {

  public static void main(String[] args) throws IOException {
    Scanner in = null;
    PrintWriter out = null;
    try {
      in = new Scanner(Paths.get("README.md"));
      out = new PrintWriter("tmp/out.txt");
      while (in.hasNext()) {
        out.println(in.next().toLowerCase());
      }
    } finally {
      safeClose(out);
      safeClose(in);
    }
  }

  private static void safeClose(Closeable res) {
    try {
      if (res != null) {
        res.close();
      }
    } catch (IOException e) {
      ;
    }
  }

}
