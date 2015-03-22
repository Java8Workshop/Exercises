package com.tasktoys.java8ws.mrbearing.ch1.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Collection2<T> extends Collection<T>{
  default void forEachIf(Consumer<T> action,Predicate<T> filter) {
    Objects.requireNonNull(filter);
    Objects.requireNonNull(action);
    for (T t : this) {
      if(filter.test(t))
        action.accept(t);
    }
  }
}


//これでいいのか不安。。
class ArrayList2<E> extends ArrayList<E> implements Collection2<E>{
  private static final long serialVersionUID = -3334525282869819981L;
}


//どのような場面でそのメソッドを活用できるでしょうか
//　=>　構文解析など活用可能ではないでしょうか。
public class Ex9 {
  
  public static void main(String[] args) {
    ArrayList2<String> arrayList2 = new ArrayList2<>();
    arrayList2.add("b000");
    arrayList2.add("bOOO");
    arrayList2.add("bo00");
    arrayList2.add("boOO");
    arrayList2.add("booO");
    
    System.out.println("forEachIf");
    arrayList2.forEach(System.out::println);
    System.out.println("forEachIf");
    arrayList2.forEachIf(System.out::println, (String a)-> a.contains("0") );
    
  }

}
