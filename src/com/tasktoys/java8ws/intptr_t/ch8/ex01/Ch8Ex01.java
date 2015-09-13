package com.tasktoys.java8ws.intptr_t.ch8.ex01;

public class Ch8Ex01 {
	public static void main(String[] args) {
		// 符号無し: (1 + 2147483647) = 2147483648 (0x80000000)
		// 符号付き: (1 + 2147483647) = -2147483648 (0x80000000)
		System.out.print(add(1, Integer.MAX_VALUE));
		System.out.print(" ");
		int sadd = 1 + Integer.MAX_VALUE;
		System.out.println(sadd);
		
		// 符号無し: (0 - 1) = 4294967295(0xffffffff)
		// 符号付き: (0 - 1) = -1        (0xffffffff)
		System.out.print(sub(0, 1));
		System.out.print(" ");
		int ssub = 0 - 1;
		System.out.println(ssub);
		
		// 0x80000001 := 4294967295  (符号無しのとき)
		// 0x80000001 := -2147483647 (符号付きのとき)
		// 符号無し:  4294967295 / 2147483647 = 1
		// 符号付き: -2147483647 / 2147483647 = -1
		System.out.print(div(-2147483647, 2147483647));
		System.out.print(" ");
		int sdiv = -2147483647 / 2147483647;
		System.out.println(sdiv);

		// 符号無し: (0xffffffff - 0) > 0
		// 符号付き: (-1 - 0) < 0
		System.out.print(cmp(0xffffffff, 0));
		System.out.print(" ");
		int scmp = Integer.compare(0xffffffff, 0);
		System.out.println(scmp);

		// 計算方法: a % b = c ...d (検算: c * b + d = a)
		// 符号無し: 1 % -1 = -1 余り 0 (検算: -1 * -1 + 0 = 1)
		// 符号付き: 1 % 4294967295 = 0 余り 1 (検算: 0 * 4294967295 + 1 = 1)
		System.out.print(mod(1, -1));
		System.out.print(" ");
		int smod = 1 % -1;
		System.out.println(smod);
	}
	
	public static long add(int x, int y) {
		return Integer.toUnsignedLong(x + y);
	}
	
	public static long sub(int x, int y) {
		return Integer.toUnsignedLong(x - y);
	}

	public static int div(int x, int y) {
		return Integer.divideUnsigned(x, y);
	}
	
	public static long mod(int x, int y){
		return Integer.remainderUnsigned(x, y);
	}
	
	public static int cmp(int x, int y){
		return Integer.compareUnsigned(x, y);
	}
}
