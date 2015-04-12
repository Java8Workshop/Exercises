package com.tasktoys.java8ws.mrbearing.ch2.ex3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

class StopWach{
  private long start;
  private long end;
  
  
  public StopWach(){
    this.start = 0L;
    this.end =0L;
  }
  
  public void reset(){
    this.start = 0L;
    this.end =0L;
  }
  
  public void start(){
    this.start = System.nanoTime();
  }
  
  
  public void stop(){
    this.end = System.nanoTime();
  }
  
  public long getNanoTime(){
    return end -start;
  }
  
  
}


public class WordCounterBench {
  
  public static void main(String[] args) throws IOException{
    String contents = new String(Files.readAllBytes(Paths.get("out/war_and_peace.txt")), StandardCharsets.UTF_8);
    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
    StopWach stopWach = new StopWach();
    
    stopWach.start();
    words.stream().filter(w -> w.length() > 12).count();
    stopWach.stop();
    System.out.println("seq "+ stopWach.getNanoTime()+"ns");
    stopWach.reset();
    
    stopWach.start();
    words.parallelStream().filter(w-> w.length() > 12).count();
    stopWach.stop();
    System.out.println("para "+ stopWach.getNanoTime()+"ns");
  }
}
