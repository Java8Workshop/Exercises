package com.tasktoys.java8ws.mrbearing.ch1.ex3;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtensionFinder {

  public static List<File> listFileByExteinsion(File directory, String ext) {
    List<File> resultFileList = new ArrayList<>();
    String[] fileStringArray = directory.list((File file , String string ) -> {
      return string.endsWith(ext);
    });
    for(String path : fileStringArray){
      resultFileList.add(Paths.get(path).toFile());
    }
    
    return resultFileList;
  }

  public static void main(String[] args) {
    Path currentPath = Paths.get("./", "src","com","tasktoys","java8ws",
        "mrbearing","ch1","ex1");
    String ext = "java";
    File dir = currentPath.toFile();

    
    List<File> resultFileList = listFileByExteinsion(dir, ext);
    
    resultFileList.forEach(System.out::println);
    
  }

}
