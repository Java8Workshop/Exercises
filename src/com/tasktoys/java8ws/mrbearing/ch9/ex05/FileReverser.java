package com.tasktoys.java8ws.mrbearing.ch9.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileReverser {
  
  public static void main(String[] args) throws IOException{
    Path readme = Paths.get("./README.md");
    Path out = Paths.get("./out/EMDAER.md");
    
    
    byte[] readme_byte = Files.readAllBytes(readme);
    byte[] output = new byte[readme_byte.length];
    for(int i=0 ;i < readme_byte.length ; i++){
      output[i] = readme_byte[readme_byte.length -i -1];
      //System.out.println("out:"+output[i]+"re:"+readme_byte[readme_byte.length -i -1]);
    }
    
    if(Files.notExists(out,LinkOption.NOFOLLOW_LINKS))
      Files.createFile(out);
    
    Files.write(out, output, StandardOpenOption.WRITE);
    
    
  }

}
