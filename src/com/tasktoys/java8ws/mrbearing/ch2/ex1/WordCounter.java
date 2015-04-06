package com.tasktoys.java8ws.mrbearing.ch2.ex1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordCounter {
  
  private final int wordLength;
  //private final int segmentSize;

  public static void main(String[] args) throws IOException {
    String contents = new String(Files.readAllBytes(
        Paths.get("out/alice.txt")),StandardCharsets.UTF_8);

    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

    WordCounter counter = new WordCounter(12);
    
    System.out.println("All count "+ words.size());
    System.out.println("seq:"+counter.countSeq(words));
    System.out.println("para:"+counter.countPara(words,10));
    
  }
  
  public WordCounter(int wordLenght){
    this.wordLength = wordLenght;
    //this.segmentSize = segmentSize;
  }
  
  public int countSeq(List<String> words){
    int count= 0;
    for(String w : words){
      if(w.length() > wordLength) count++;
    }
    
    return count;
  }
  
  private int count = 0;
  public int countPara(List<String> words,int segment){
    
    int begin =0;
    int end = segment;
    List<List<String>> segList = new ArrayList<List<String>>();
    
    while(true){
      if(end >= words.size())
        words.subList(begin, end);
      
    }
  }
  
  
}
