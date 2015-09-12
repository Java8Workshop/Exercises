package com.tasktoys.java8ws.hosoai.ch8.ex03;

public class GreatestCommonDivisor {
	static int gcd(int a, int b){
		if(b==0) return a;
		if(Math.abs(a)>=Math.abs(b)){
			return gcd(b, Math.abs(a%b));			
		}else{
			return gcd(a, Math.abs(b%a));
		}
	}
	
	static int gcd_floorMode(int a, int b){
		if(b==0) return a;
		return gcd(b, Math.floorMod(a, b));
	}
	static int gcd_rem(int a, int b){
		if(b==0) return a;		
		return gcd(b, Math.abs(a%b));
	}
	
	public static void main(String[] args) {
		int a = -1029;
		int b = 1071;
		System.out.println(gcd(a,b));
		System.out.println(gcd_floorMode(a,b));
		System.out.println(gcd_rem(a,b));
	}
}
