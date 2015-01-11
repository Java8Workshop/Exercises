package com.tasktoys.java8ws.intptr_t.ch9.ex09;

import java.util.Objects;

class LabeledPoint {
	private String label;
	private int x;
	private int y;
	
	public LabeledPoint(String label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals( Object otherObject ) {
		if(otherObject == null) {
			return false;
		}
		if(this == otherObject){
			return true;
		}
		if(getClass() != otherObject.getClass()) {
			return false;
		}

		LabeledPoint other = (LabeledPoint)otherObject;
		return (Objects.equals(this.label, other.label)) &&
			   (this.x == other.x) &&
			   (this.y == other.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.label, this.x, this.y );
	}
}

public class Ch9Ex09 {
	public static void main(String[] args) {
		LabeledPoint base = new LabeledPoint("1", 2, 3);
		LabeledPoint same = new LabeledPoint("1", 2, 3);
		LabeledPoint dif1 = new LabeledPoint("0", 2, 3);
		LabeledPoint dif2 = new LabeledPoint("1", 0, 3);		
		LabeledPoint dif3 = new LabeledPoint("1", 2, 0);
		LabeledPoint nil = new LabeledPoint( null, 2, 3 );

		System.out.println("hash: " +
				base.hashCode() + "," +
				same.hashCode() + "," +
				dif1.hashCode() + "," + 
				dif2.hashCode() + "," + 
				dif3.hashCode() );

		System.out.println("equals:");
		System.out.println("null: " + base.equals(null));
		System.out.println("base: " + base.equals(base));
		System.out.println("same: " + base.equals(same));
		System.out.println("dif1: " + base.equals(dif1));
		System.out.println("dif2: " + base.equals(dif2));
		System.out.println("dif3: " + base.equals(dif3));
		System.out.println("nil : " + base.equals(nil));
	}
}
