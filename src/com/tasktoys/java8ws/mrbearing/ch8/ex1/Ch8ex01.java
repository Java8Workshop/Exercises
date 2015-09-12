package com.tasktoys.java8ws.mrbearing.ch8.ex1;

import java.math.BigInteger;

public class Ch8ex01 {
	public static int add(int a, int b){
		 BigInteger aBig = new BigInteger(new Integer(a).toString());
		 BigInteger bBig = new BigInteger(new Integer(b).toString());
		 return aBig.add(bBig).intValue();
	}

	public static int subtract(int a , int b){
		 BigInteger aBig = new BigInteger(new Integer(a).toString());
		 BigInteger bBig = new BigInteger(new Integer(b).toString());
		return aBig.subtract(bBig).intValue();
	}

	public static int divide(int a ,int b){
		BigInteger aBig = new BigInteger(new Integer(a).toString());
		 BigInteger bBig = new BigInteger(new Integer(b).toString());
		 return aBig.divide(bBig).intValue();
	}



	public static int compareTo(int a ,int b){
		BigInteger aBig = new BigInteger(new Integer(a).toString());
		 BigInteger bBig = new BigInteger(new Integer(b).toString());
		 return aBig.compareTo(bBig);
	}


/**
 * ?????
 * わからない
 * @param args
 */
	public static void main(String[]  args){
		System.out.println("");

	}
}
