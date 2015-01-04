package com.tasktoys.java8ws.intptr_t.ch9.ex10;

import java.util.Objects;

class LabeledPoint implements Comparable<LabeledPoint> {
	private String label;
	private int x;
	private int y;
	
	public LabeledPoint( String label, int x, int y ) {
		this.label = label;
		this.x = x;
		this.y = y;
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
		Objects.requireNonNull(o);

		int diff;		
		if( !Objects.equals(this.label, o.label) ) {
			Objects.requireNonNull(o.label);
			diff = this.label.compareTo(o.label);
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
		LabeledPoint nil = new LabeledPoint(null, 2, 3);
		
		System.out.println("hash: " +
				base.hashCode() + "," +
				same.hashCode() + "," +
				dif1.hashCode() + "," + 
				dif2.hashCode() + "," + 
				dif3.hashCode() );		
		System.out.println("null: " + base.equals(null));
		System.out.println("base: " + base.equals(base));
		System.out.println("same: " + base.equals(same));
		System.out.println("dif1: " + base.equals(dif1));
		System.out.println("dif2: " + base.equals(dif2));
		System.out.println("dif3: " + base.equals(dif3));
		System.out.println("nil:  " + base.equals(nil));		
		System.out.println();
		try{
			System.out.println(base.compareTo(null));
		} catch( NullPointerException e ) {
			System.out.println(e);
		}

		System.out.println(base.compareTo(base));		
		System.out.println(base.compareTo(same) + " : " + same.compareTo(base) );
		System.out.println(base.compareTo(dif1) + " : " + dif1.compareTo(base) );
		System.out.println(base.compareTo(dif2) + " : " + dif2.compareTo(base) );
		System.out.println(base.compareTo(dif3) + " : " + dif3.compareTo(base) );
		try {
			System.out.println(base.compareTo(nil));
		} catch( NullPointerException e ) {
			System.out.print(e);
		}
		System.out.print(" : ");
		try {
			System.out.println(nil.compareTo(base));
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
}
