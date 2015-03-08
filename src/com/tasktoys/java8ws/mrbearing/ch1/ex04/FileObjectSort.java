package com.tasktoys.java8ws.mrbearing.ch1.ex04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileObjectSort {

  private static final File OUT = Paths.get("out","mrbearing").toFile();
  
  public static void fileSort(File[] fileArray) {

    Arrays.sort(fileArray, (File f1, File f2) -> {

      if(f1 == null)
        return -1;
      if(f2 == null)
        return 1;
      
      Path path1 = f1.toPath();
      Path path2 = f2.toPath();

      /**if (Files.isDirectory(path1) && Files.isDirectory(path2)) {
        String pathString1 = path1.toString();
        String pathString2 = path2.toString();

        return pathString1.compareTo(pathString2);
      } else/**/
        if (Files.isDirectory(path1) && (!Files.isDirectory(path2))) {
        return -1;

      } else if ((!Files.isDirectory(path1)) && Files.isDirectory(path2)) {
        return 1;
      } else {
        String pathString1 = path1.toString();
        String pathString2 = path2.toString();

        return pathString1.compareTo(pathString2);
      }

    });
  }

  public static void main(String[] args) throws IOException {
    
    
    List<Path> pathList = new ArrayList<>();
    File[] fileArray = null;
    //FileDeleter.deleteIfExists(OUT);
    OUT.mkdirs();
       
    
    try {
      pathList.add(Files.createFile(Paths.get("out","mrbearing", "0.txt")));
      pathList.add(Files.createFile(Paths.get("out","mrbearing", "1.txt")));
      pathList.add(Files.createFile(Paths.get("out","mrbearing", "2.txt")));
      pathList.add(Files.createFile(Paths.get("out","mrbearing", "3.txt")));
      
      fileArray = new File[4];
      
    } catch (IOException e) {
      e.printStackTrace();
    }

       
    FileObjectSort.fileSort(fileArray);
    
    

  }
}
