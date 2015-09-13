package com.tasktoys.java8ws.intptr_t.ch8.ex03;

/**
 * 答えを格納するためだけのクラス
 */
class TupleInt3
{
	final int item1;
	final int item2;
	final int item3;
	
	private TupleInt3(int item1, int item2, int item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	public static TupleInt3 of(int item1, int item2, int item3) {
		return new TupleInt3(item1, item2, item3);
	}
	
	@Override
	public String toString() {
		return "(" + this.item1 + ", " + this.item2 + ", " + this.item3 + ")";
	}
}

@FunctionalInterface
interface ModFunction{
	int apply(int a, int b);
}

// ModFunctionと区別を付けるためのインターフェース
interface GcdFunction {
	int apply(int a, int b);
}

class GcdImpl implements GcdFunction {
	private ModFunction mod;

	public GcdImpl(ModFunction mod) {
		this.mod = mod;
	}
	
	@Override
	public int apply(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			int r = this.mod.apply(a, b);
			return apply(b, r);
		}
	}
}

public class Ch8Ex03 {
	public static void main(String[] args) {		
		System.out.println( gcd(14, 4) );
		System.out.println( gcd(14, -4) );
		System.out.println( gcd(-14, 4) );
		System.out.println( gcd(-14, -4) );
	}
	
	static TupleInt3 gcd(int a, int b) {
		return TupleInt3.of(gcdWithMod(a, b),
				            gcdWithFloorMod(a, b),
				            gcdWithRem(a, b));
	}	
	
	static int gcdMain(int a, int b, GcdFunction func) {
		a = Math.abs(a);
		b = Math.abs(b);
		if(a < b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		return func.apply(a, b);
	}
	
	static int gcdWithMod(int a, int b) {
		return gcdMain(a, b, new GcdImpl((aa, bb) -> aa % bb ));
	}
	static int gcdWithFloorMod(int a, int b) {
		return gcdMain(a, b, new GcdImpl((aa, bb) -> Math.floorMod(aa, bb)));
	}
	static int gcdWithRem(int a, int b) {
		return gcdMain(a, b, new GcdImpl((aa, bb) -> rem(aa, bb)));		
	}	

	static int rem(int a, int b) {		
		if(a > 0 && b > 0) {
			return a % b;
		} else if(a > 0 && b < 0) {
			return a % b;
		} else if(a < 0 && b > 0) {
			return Math.abs(a % b);
		} else {
			return Math.abs(a % b);
		}
	}
}
