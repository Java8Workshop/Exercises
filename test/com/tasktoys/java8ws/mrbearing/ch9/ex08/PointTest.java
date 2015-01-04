package com.tasktoys.java8ws.mrbearing.ch9.ex08;

import static org.junit.Assert.*;

import org.junit.Test;


public class PointTest {

  @Test
  public void test() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);

    assertTrue(p1.compareTo(p2) > 0);
    
  }
  
  @Test
  public void testCompareTo_normalCase() {
      Point p1 = new Point(5, 5);
      Point p2 = new Point(1, 1);
      assertTrue(p1.compareTo(p2) > 0);
  }

  @Test
  public void testCompareTo_overflowCase() {
      Point p1 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
      Point p2 = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
      assertTrue(p1.compareTo(p2) > 0);
  }

  
  

}
