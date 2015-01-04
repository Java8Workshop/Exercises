package com.tasktoys.java8ws.mrbearing.ch9.ex08;

public class Point {

  private int x;
  private int y;

  public Point(int _x, int _y) {
    super();
    this.x = _x;
    this.y = _y;

  }

  public int conpareToOrg(Point other) {

    int diff = Integer.compare(x, other.x);
    if (diff != 0)
      return diff;
    return Integer.compare(y, other.y);

  }

  public int compareTo(Point other) {
    long diff = this.x - other.x;
    if (diff != 0)
      return (int) diff;

    long diffY = this.y - other.y;
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
