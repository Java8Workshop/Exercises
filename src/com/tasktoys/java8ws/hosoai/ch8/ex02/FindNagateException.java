package com.tasktoys.java8ws.hosoai.ch8.ex02;

/*
       Long.MIN_VALUE :-9223372036854775808
       Long.MAX_VALUE : 9223372036854775807
negate(Long.MIN_VALUE): 9223372036854775808
 */
public class FindNagateException {
	public static void main(String[] args) {
		try{
			System.out.println("       Long.MIN_VALUE :"+Long.MIN_VALUE);
			System.out.println("       Long.MAX_VALUE : "+Long.MAX_VALUE);
			System.out.println("negate(Long.MIN_VALUE): 9223372036854775808");
			Math.negateExact(Long.MIN_VALUE);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
