package com.tasktoys.java8ws.mrbearing.ch9.ex08;

public class Point {

  private int x;
  private int y;

  public Point(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }

  public int conpareToOrg(Point other) {

    int diff = Integer.compare(x, other.x);
    if (diff != 0)
      return diff;
    return Integer.compare(y, other.y);

  }

  public int compareTo(Point other) {
    long diff = (long) this.x - (long) other.x;
    if (diff != 0)
      return diff > 0 ? 1 : -1;

    long diffY = (long) this.y - (long) other.y;
    if (diffY != 0)
      return diffY > 0 ? 1 : -1;
      
    return (int) diffY;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
