package com.tasktoys.java8ws.mrbearing.ch1.ex9;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ex9 {

  interface Collection2<T> extends Collection<T>{
    default void forEachIf(Consumer<T> action,Predicate<T> filter) {
      Objects.requireNonNull(action);
      for (T t : this) {
        if(filter.test(t))
          action.accept(t);
      }
    }
  }
  
  public static void main(String[] args) {
    
    
  }

}
