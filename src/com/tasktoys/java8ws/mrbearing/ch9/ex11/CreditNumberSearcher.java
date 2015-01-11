package com.tasktoys.java8ws.mrbearing.ch9.ex11;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CreditNumberSearcher {

  private static final String CMD_FINDSTR = "findstr";
  private static final String REGXP = "\"[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9]\"";
  private static final Path OUTPUT_PATH = Paths.get("out/ch9_11credits.txt");

  public static void main(String[] args) throws InterruptedException,
      IOException {
    String homePath = System.getProperty("user.home") + "\\test\\test.txt";

    //System.out.println(homePath);
    //System.out.println(OUTPUT_PATH);
    try{
    Files.createFile(OUTPUT_PATH);
    }catch(FileAlreadyExistsException ex){
      
    }
    
    ProcessBuilder bulider = new ProcessBuilder(CMD_FINDSTR,
        "/S",
        "/I", REGXP,
        homePath);
    bulider.redirectOutput(OUTPUT_PATH.toFile());
    System.out.println(bulider.command());
    List<String> lines = Files.readAllLines(OUTPUT_PATH);
    System.out.println("");
    for(String s : lines) System.out.println(s);
    Process process = bulider.start();
    process.waitFor();

  }

}
