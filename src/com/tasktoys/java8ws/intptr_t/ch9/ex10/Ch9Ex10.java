package com.tasktoys.java8ws.intptr_t.ch9.ex10;

import java.util.Objects;

class LabeledPoint implements Comparable<LabeledPoint>
{
	private String label;
	private int x;
	private int y;
	
	public LabeledPoint( String alabel, int ax, int ay ) {
		this.label = alabel;
		this.x = ax;
		this.y = ay;
	}
	
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
	
	public int hashCode() {
		return Objects.hash(this.label, this.x, this.y );
	}

	@Override
	public int compareTo(LabeledPoint o) {
		if( o == null ) {
			return -1;
		}

		int diff;
		diff = this.label.compareTo(o.label);
		if(diff != 0) {
			return diff;
		}
		diff = Integer.compare(this.x, o.x);
		if(diff != 0) {
			return diff;
		}
		diff = Integer.compare(this.y, o.y);
		
		return diff;
	}
}

public class Ch9Ex10 {
	public static void main(String[] args) {
		LabeledPoint base = new LabeledPoint("1", 2, 3);
		LabeledPoint same = new LabeledPoint("1", 2, 3);
		LabeledPoint dif1 = new LabeledPoint("0", 2, 3);
		LabeledPoint dif2 = new LabeledPoint("1", 0, 3);		
		LabeledPoint dif3 = new LabeledPoint("1", 2, 0);
		
		System.out.println("hash: " +
				base.hashCode() + "," +
				same.hashCode() + "," +
				dif1.hashCode() + "," + 
				dif2.hashCode() + "," + 
				dif3.hashCode() );		
		System.out.println(base.equals(null));
		System.out.println(base.equals(base));
		System.out.println(base.equals(same));
		System.out.println(base.equals(dif1));
		System.out.println(base.equals(dif2));
		System.out.println(base.equals(dif3));
		System.out.println();
		System.out.println(base.compareTo(null));
		System.out.println(base.compareTo(base));		
		System.out.println(base.compareTo(same));
		System.out.println(base.compareTo(dif1));
		System.out.println(base.compareTo(dif2));
		System.out.println(base.compareTo(dif3));		
	}
}
