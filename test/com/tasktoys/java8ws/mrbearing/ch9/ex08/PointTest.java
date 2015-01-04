package com.tasktoys.java8ws.mrbearing.ch9.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

  @Test
  public void test() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);

    if (p1.compareTo(p2) < 0)
      ;
    else
      fail("boooo");
    
  }

}
