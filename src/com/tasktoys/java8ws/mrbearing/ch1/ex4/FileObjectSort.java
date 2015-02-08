package com.tasktoys.java8ws.mrbearing.ch1.ex4;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;

public class FileObjectSort {

  public static void fileSort(File[] fileArray){

    
    Arrays.sort(fileArray,(File f1 ,File f2) -> {
      
      Path path1 = f1.toPath();
      Path path2 = f2.toPath();
      
      if(Files.isDirectory(path1)
          && Files.isDirectory(path2)){
        
        String pathString1 = path1.toString();
        String pathString2 = path2.toString();
        
        return pathString1.compareTo(pathString2);
      }
      else if(Files.isDirectory(path1)
          &&( ! Files.isDirectory(path2))){
        return -1;
        
      }
      else if( (!Files.isDirectory(path1))
          && Files.isDirectory(path2)){
        return 1;
      }else{
        String pathString1 = path1.toString();
        String pathString2 = path2.toString();
        
        return pathString1.compareTo(pathString2);
      }
      
      
    });
  }
  
  
  public static void main(String[] args){
    File[] file_array = new File[10];
    
  }
}
