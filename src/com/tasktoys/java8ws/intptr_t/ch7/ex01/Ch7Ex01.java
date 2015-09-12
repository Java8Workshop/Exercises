package com.tasktoys.java8ws.intptr_t.ch7.ex01;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;

//
// Nashorn で実現する場合
// 
// 簡単にかけるが、REPLが辛い。。。
// HashMapなどはHashMap#put,HashMap#getを用いず、ブラケット記法でアクセスできるので便利
//
//[インスタンス生成、staticメソッドアクセス]
// var year = new java.lang.Integer(2015);
// var month = 8;
// var time = java.time.ZonedDateTime.of(year, 8, 23, 1, 2, 3, 4, java.time.ZoneId.of("Asia/Tokyo"));
// print(time);
//
//[Java.typeのお試し、ジェネリッククラス、HashMapは型付きの連想配列の様に使える]
// var HashMap = Java.type('java.util.HashMap');
// var map = new HashMap();
// map.put(1, "1")
// map['1'] = 100
// print(map);
// map.get('1');
// map[1];
//
//以下は上記のHashMapの様な動きはしない(真に連想配列ではなく、プロパティを設定している)
// var map2 = {};
// map2[1] = 1;
// map2['1'] = 100;
// map2[1];
// map2['1'];
//

public class Ch7Ex01 {
	@SuppressWarnings("unchecked")	// HashMap#putの警告回避のため
	public static void main(String[] args) {
		Integer year = new Integer(2015);
		int month = 8;
		ZonedDateTime time = ZonedDateTime.of(year, month, 23, 1, 2, 3, 4, ZoneId.of("Asia/Tokyo"));
		System.out.println(time);
		
		@SuppressWarnings("rawtypes")
		HashMap map = new HashMap<>();
		map.put(1, "1");
		map.put("1", 100);
		System.out.println(map.get(1));
		System.out.println(map.get("1"));
	}
}

