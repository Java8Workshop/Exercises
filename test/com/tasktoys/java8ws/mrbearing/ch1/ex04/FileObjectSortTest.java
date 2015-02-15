package com.tasktoys.java8ws.mrbearing.ch1.ex04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tasktoys.java8ws.mrbearing.ch1.ex4.FileObjectSort;
import com.tasktoys.java8ws.util.FileDeleter;

public class FileObjectSortTest {

  private static final File OUT = Paths.get("out","mrbearing").toFile();

  @Test
  public void testFileSort() {

    List<Path> pathList = new ArrayList<>();
    File[] fileArray = null;
    FileDeleter.deleteIfExists(OUT);
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

   //.forEach(System.out::println);
    
    //fail("まだ実装されていません");
  }
}
