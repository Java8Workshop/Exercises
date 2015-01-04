package com.tasktoys.java8ws.mrbearing.ch9.ex09;

import java.util.Objects;

import com.tasktoys.java8ws.mrbearing.ch9.ex08.Point;

public class LabeledPoint {

  private String label;
  private int x;
  private int y;

  public LabeledPoint(String _label, int _x, int _y) {
    super();
    this.label = _label;
    this.x = _x;
    this.y = _y;
  }
  
  @Override
  public int hashCode(){
    return Objects.hash(this.label,this.x,this.y);
  }

  @Override
  public boolean equals(Object otherObject) {
    if(this == otherObject)
      return true;
    if (otherObject == null)
      return false;
    if(getClass() != otherObject.getClass())
      return false;
    LabeledPoint other = (LabeledPoint) otherObject;
    
    return Objects.equals(label, other.label) && Objects.equals(x, other.x)
        && Objects.equals(y, other.y);
  }
  
  
  

}
