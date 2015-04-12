package com.tasktoys.java8ws.mrbearing.ch2.ex4;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamValue {

  public static void main(String[] args) {
    int[] values = {1,4,9,16};
    
    Stream<int[]> s = Stream.of(values);
    Stream<Integer> intStream = Arrays.stream(values).boxed();
    
    s.forEach(System.out::println);
    System.out.println("*****");
    intStream.forEach(System.out::println);
  }

}
