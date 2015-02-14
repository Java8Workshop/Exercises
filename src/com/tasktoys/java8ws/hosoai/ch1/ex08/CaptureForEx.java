package com.tasktoys.java8ws.hosoai.ch1.ex08;

import java.util.ArrayList;
import java.util.List;

public class CaptureForEx {
	public void callNamesByForEx(){
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<>();
		for(String name : names){
			runners.add(()->System.out.println(name));
		}
		names[1] = "Hoge";
		for(Runnable r :runners){
			r.run();
		}
		
		Object[] objects = new Object[]{1, "Test", new ArrayList<Runnable>()};
		for(Object obj : objects){
			runners.add(()->System.out.println(obj));
		}
		for(Runnable r :runners){
			r.run();
		}
		
		runners.clear();
	}
	
	private int i; // クラス変数にすればキャプチャできるが・・・．		
	private String[] names = {"Peter", "Paul", "Mary"};
	private List<Runnable> runners = new ArrayList<>();
	public void callNamesByFor(){
		//for(int i=0;i<names.length;i++){ // ローカルスコープの変数はコンパイルではねられる．クラス変数にしたら実行時に参照できなくてダメっぽい．
		for(i=0;i<names.length;i++){
			runners.add(()->System.out.println(names[i]));
		}
		for(Runnable r :runners){
			r.run();
		}
	}
	
	public static void main(String[] args) {
		new CaptureForEx().callNamesByForEx();
//		new CaptureForEx().callNamesByFor();
	}
}
