package com.tasktoys.java8ws.mrbearing.ch9.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileLineReverser {

  public static void main(String[] args) throws IOException {
    Path readme = Paths.get("./README.md");
    Path out = Paths.get("./out/EMDAER_line.md");
    List<String> lines =  Files.readAllLines(readme);
    Stack<String> revers = new Stack<>();
    List<String> outLines = new ArrayList<String>();
    
    for(String l : lines)
      revers.push(l);
    
    while( ! revers.empty()){
      String l = revers.pop();
      outLines.add(l);
      //System.out.println(l);
    }
    
    if(Files.notExists(out,LinkOption.NOFOLLOW_LINKS))
      Files.createFile(out);
    Files.write(out, outLines, StandardOpenOption.WRITE);
    
    

  }

}
