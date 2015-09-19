package com.tasktoys.java8ws.intptr_t.ch8.ex12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ch8Ex12 {
	public static void main(String[] args)
			throws IllegalAccessException,
				   IllegalArgumentException,
				   InvocationTargetException,
				   InstantiationException
	{
		for(Method method : Ch8Ex12.class.getMethods()){
			for(TestCase testCase : method.getAnnotationsByType(TestCase.class)){
				Object instance = method.getDeclaringClass().newInstance();
				int params = Integer.parseInt(testCase.params());
				long expacted = Long.parseLong(testCase.expected());

				long ans = (long)method.invoke(instance, params);
				
				System.out.print(expacted == ans ? "OK: " : "NG: ");
				System.out.println(method.getName() + "(" + params + ") => " + expacted + " --- " + ans);
			}
		}
	}
	
	@TestCase(params="4", expected="24") // OK
	@TestCase(params="0", expected="1")	 // OK
	@TestCase(params="0", expected="10") // NG
	public static long factorial(int n) {
		if(n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	@TestCase(params="4", expected="24") // OK
	@TestCase(params="0", expected="10") // NG
	@TestCase(params="0", expected="1")  // OK
	public long factorialInstance(int n) {
		return factorial(n);
	}
}
