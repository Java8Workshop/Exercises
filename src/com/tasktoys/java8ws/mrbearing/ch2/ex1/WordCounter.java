package com.tasktoys.java8ws.mrbearing.ch2.ex1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Counter {
  private int count;

  public Counter() {
    this.count = 0;
  }

  public int getCount() {
    return this.count;
  }

  public synchronized int countUp(int c) {
    this.count += c;

    return this.count;
  }

}

public class WordCounter {

  // private final int wordLength;
  // private final int segmentSize;

  public static void main(String[] args) throws IOException,
      InterruptedException {
    String contents = new String(
        Files.readAllBytes(Paths.get("out/alice.txt")), StandardCharsets.UTF_8);

    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

    // WordCounter counter = new WordCounter(12);

    System.out.println("All count " + words.size());
    System.out.println("seq:" + countSeq(words, 12));
    System.out.println("para:" + countPara(words, 12, 200));

  }

  public static int countSeq(List<String> words, int wordLength) {
    int count = 0;
    for (String w : words) {
      if (w.length() > wordLength)
        count++;
    }

    return count;
  }

  public static Counter counter = new Counter();

  public static int countPara(List<String> words, int wordLength, int segment)
      throws InterruptedException {

    int begin = 0;
    int end = segment - 1;
    // List<List<String>> segList = new ArrayList<List<String>>();
    List<Thread> threadList = new ArrayList<Thread>();

    while (true) {
      if (end >= words.size()) {
        end = words.size() - 1;
        List<String> wordlist = words.subList(begin, end);
        threadList.add(new Thread(() -> {
          counter.countUp(countSeq(wordlist, wordLength));
        }));
        break;
      }
      List<String> wordlist = words.subList(begin, end);
      threadList.add(new Thread(() -> {
        counter.countUp(countSeq(wordlist, wordLength));
      }));

      begin = end + 1;
      end += segment;
    }
    
    System.out.println(threadList.size());

    for (Thread thread : threadList) {
      thread.start();
    }

    for (Thread thread : threadList) {
      thread.join();
    }
    return counter.getCount();

  }

}
