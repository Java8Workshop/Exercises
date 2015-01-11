/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.namikawa.ch9.ex10;

import java.util.Objects;

/**
 *
 * @author takanori
 */
public class LabeledPoint {

    private String label;
    private int x;
    private int y;

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        LabeledPoint other = (LabeledPoint) otherObject;
        return Objects.equals(x, other.x) && Objects.equals(y, other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int compareTo(LabeledPoint other) {
        int diff = Integer.compare(x, other.x);

        if (diff != 0) {
            return diff;
        }

        return Integer.compare(y, other.y);
    }
    
    public static void main(String args[]){
    
        LabeledPoint lp1 = new LabeledPoint();
        LabeledPoint lp2 = new LabeledPoint();
        
        lp1.x=2000000000;
        lp1.y=2000000000;
    
        lp2.x=-2000000000;
        lp2.y=2000000000;
        
        System.out.println(lp1.compareTo(lp2));
        
    }

}
