package com.tasktoys.java8ws.hosoai.ch1.ex11;

public class InterfaceInheritance extends S implements I, J{

}

interface I {
	public void f();
}
interface Id {
	public default void f(){
		System.out.println("I default method");
	}
}
interface Is {
	public static void f(){
		System.out.println("I static method");		
	}
}

interface J {
	public void f();
}
interface Jd {
	public default void f(){
		System.out.println("J default method");
	}
}
interface Js {
	public static void f(){
		System.out.println("J static method");		
	}
}

class S{
	public void f(){
		System.out.println("S method");
	}
}

class IJ implements I,J{
	@Override
	public void f() {
		System.out.println("override");
	}
}

// OverrideしないとConflictエラー
class IJd implements I,Jd{
	@Override
	public void f() {
		System.out.println("override");
	}	
}

class IJs implements I,Js{
	@Override
	public void f() {
		System.out.println("override");
	}
}

//OverrideしないとConflictエラー
class IdJ implements Id,J{
	@Override
	public void f() {
		System.out.println("override");
	}	
}
//Overrideしないとデフォルトメソッド名が重複している旨のエラー
class IdJd implements Id,Jd{
	@Override
	public void f() {
		System.out.println("override");
	}	
}

//デフォルトメソッドのみ引き継ぎ，スタティックメソッドは直接Jsを指定しないとだめっぽい．
class IdJs implements Id,Js{
}

class IsJ implements Is, J{
	@Override
	public void f() {
		System.out.println("override");
	}
}
//デフォルトメソッドのみ引き継ぎ，スタティックメソッドは直接Isを指定しないとだめっぽい．
class IsJd implements Is, Jd{
}

//Overrideはできない．
class IsJs implements Is, Js{
	public static void f(){
		Is.f();   // 明示的にどちらのｆを使うか指定する
	}
}

class SI extends S implements I{
	
}
class SId extends S implements Id{
	
}
class SIs extends S implements Is{

}
