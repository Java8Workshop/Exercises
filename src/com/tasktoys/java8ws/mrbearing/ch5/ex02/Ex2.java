package com.tasktoys.java8ws.mrbearing.ch5.ex02;

import java.time.LocalDate;

public class Ex2 {

	public static void main(String[] args) {

		LocalDate localdate = LocalDate.of(2000,2,29);
		// add one year
		System.out.println(localdate.plusYears(1).toString());

		//add 4year
		System.out.println(localdate.plusYears(4).toString());


		//add 4times 1 year
		for(int i =0; i<4 ;i++)
			localdate = localdate.plusYears(1);

		System.out.println(localdate.toString());

	}

}
