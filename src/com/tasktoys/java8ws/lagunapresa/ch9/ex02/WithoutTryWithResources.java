package com.tasktoys.java8ws.lagunapresa.ch9.ex02;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class WithoutTryWithResources {

  public static void main(String[] args) throws IOException {
    IOException base = null;
    Scanner in = null;
    PrintWriter out = null;
    try {
      in = new Scanner(Paths.get("README.md"));
      out = new PrintWriter("tmp/out.txt");
      while (in.hasNext()) {
        out.println(in.next().toLowerCase());
      }
    } catch (IOException e) {
      base = e;
      throw e;
    } finally {
      safeClose(out, base);
      safeClose(in, base);
    }
  }

  private static void safeClose(Closeable res, IOException base) {
    try {
      if (res != null) {
        res.close();
      }
    } catch (IOException e) {
      if (base != null) {
        base.addSuppressed(e);
      }
    }
  }

}
