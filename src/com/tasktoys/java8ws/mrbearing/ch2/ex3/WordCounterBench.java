package com.tasktoys.java8ws.mrbearing.ch2.ex3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class StopWatch{
  private long start;
  private long end;
  
  
  public StopWatch(){
    this.start = 0L;
    this.end = 0L;
  }
  
  public void reset(){
    this.start = 0L;
    this.end = 0L;
  }
  
  public void start(){
    this.start = System.nanoTime();
  }
  
  
  public void stop(){
    this.end = System.nanoTime();
  }
  
  public long getNanoTime(){
    return end - start;
  }
  
  
}
/*
 * 
シリアル・パラレルを単独で各4回ずつ実行した結果
seq  　  76976433ns
seq  107613057ns
seq  122876632ns
seq  115529435ns

para 436087602ns
para 435618058ns
para 484553611ns
para 477165790ns

シリアルの方が早い？
*
*/

public class WordCounterBench {
  
  public static void main(String[] args) throws IOException{
    String contents = new String(Files.readAllBytes(Paths.get("out/war_and_peace.txt")), StandardCharsets.UTF_8);
    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
    StopWatch stopWatch = new StopWatch();
    
    /**/
    stopWatch.start();
    words.stream().filter(w -> w.length() > 12).count();
    stopWatch.stop();
    System.out.println("seq "+ stopWatch.getNanoTime()+"ns");
    stopWatch.reset();
    /**/
    /**/
    stopWatch.start();
    words.parallelStream().filter(w-> w.length() > 12).count();
    stopWatch.stop();
    System.out.println("para "+ stopWatch.getNanoTime()+"ns");
    /**/
    
  }
}
