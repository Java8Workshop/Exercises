package com.tasktoys.java8ws.mrbearing.ch2.ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch2Ex2 {

  public static void main(String[] args) throws IOException {
    String contents = new String(
        Files.readAllBytes(Paths.get("out/alice.txt")), StandardCharsets.UTF_8);

    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

    getLongFiveWord(12, 5,words.stream());
    System.out.println("execute " + count + " times");
  }

  private static int count = 0;

  public static List<String> getLongFiveWord(int length, int limit,
      Stream<String> wordStream) {
    count = 0;
    return wordStream
      .filter(w -> w.length() > length)
      .peek(e -> {
        System.out.println("peek");
        count++;
      })
      .limit(limit)
      .collect(Collectors.toList());
  }

}
