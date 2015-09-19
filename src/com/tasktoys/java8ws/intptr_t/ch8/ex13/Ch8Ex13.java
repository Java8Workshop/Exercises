package com.tasktoys.java8ws.intptr_t.ch8.ex13;

/*
実行の基準パス：
	$ cd Exercises
	$ ls
	README.md	build.xml	nbproject	src
	bin		lib		out		test

使い方の例：
	$ javac -cp ./bin -proc:only -processor com.tasktoys.java8ws.intptr_t.ch8.ex13.TestCaseProcessor src/com/tasktoys/java8ws/intptr_t/ch8/ex13/Ch8Ex13.java
	OK: factorial(4) => 24 --- 24
	OK: factorial(0) => 1 --- 1

	OK: factorialInstance(4) => 24 --- 24
	OK: factorialInstance(0) => 1 --- 1

	エラー: factorial(0) => 10 --- 1
	エラー: factorialInstance(0) => 10 --- 1
	エラー2個
 */
public class Ch8Ex13 {
	@TestCase(params="4", expected="24") // OK
	@TestCase(params="0", expected="10") // NG
	@TestCase(params="0", expected="1")  // OK
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
