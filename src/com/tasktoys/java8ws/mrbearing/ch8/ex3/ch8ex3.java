package com.tasktoys.java8ws.mrbearing.ch8.ex3;

public class ch8ex3 {

	public static int myRem(int a, int b) {
		if(a-b < 0)
			return a;
		return myRem(a-b,b);
	}

	public static int gcd(int a, int b,RemOperation op){

		//入れ替え
		if(a<b){
			int n = a;
			a= b;
			b=n;
		}

		if(b==0){
			return a;
		}
		else{
			switch(op){
				case OP:
					return gcd(b,a%b,op);

				case FLOOR_MOD:
					return gcd(b,Math.floorMod(a, b),op);

				case MY_REM:
					return gcd(b,myRem(a,b),op);
			}

		}
		return 0;



	}



	public static void main(String[] args) {

		int valGcd = gcd(1071,1029,RemOperation.OP);
		System.out.println("gcd is"+valGcd);

		valGcd = gcd(1071,1029,RemOperation.FLOOR_MOD);
		System.out.println("gcd is"+valGcd);


		valGcd = gcd(1071,1029,RemOperation.MY_REM);
		System.out.println("gcd"+valGcd);




	}

}
