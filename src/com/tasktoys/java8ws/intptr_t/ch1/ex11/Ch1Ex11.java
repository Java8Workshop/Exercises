package com.tasktoys.java8ws.intptr_t.ch1.ex11;

interface I {
	void f();
}

interface J {
	void f();
}

class S {
	public void f(){ System.out.println("S#f"); }
}

interface Iab {
	abstract void f();
}

interface Jab {
	abstract void f();
}

interface Idefault {
	default void f(){ System.out.println("Idefault#f"); }
}

interface Jdefault {
	default void f(){ System.out.println("Jdefault#f"); }
}

interface Istatic {
	static void f(){ System.out.println("Istatic#f"); }
}

interface Jstatic {
	static void f(){ System.out.println("Jstatic#f"); }
}

//==============================================================================

// I#fかJ#fを実装しなければならない
class IJ implements I, J{
	@Override
	public void f() {
		System.out.println("IJ#f");
	}
}

//Iab#fかJ#fを実装しなければならない
class IJab implements I, Jab {
	@Override
	public void f() {
		System.out.println("IJab#f");
	}
}

// I#fとJdefault#fが衝突するため、解決しなければならない
class IJdefault implements I, Jdefault {
	@Override
	public void f(){
		System.out.print("\t"); Jdefault.super.f();
		System.out.println("IJdefault#f");
	}
}

// I#fを実装しなければならない、Jstatic#fはstatic
class IJstatic implements I, Jstatic {
	@Override
	public void f() {
		System.out.println("IJstatic#f");
	}
}

//------------------------------------------------------------------------------

// Iab#fかJ#fを実装しなければならない
class IabJ implements Iab, J {
	@Override
	public void f() {
		System.out.println("IabJ#f");
	}
}

// Iab#fかJab#fを実装しなければならない
class IabJab implements Iab, Jab {
	@Override
	public void f() {
		System.out.println("IabJab#f");
	}	
}

// Iab#fとJdefault#fが衝突するため、解決しなければならない
class IabJdefault implements Iab, Jdefault {
	@Override
	public void f(){
		System.out.print("\t"); Jdefault.super.f();
		System.out.println("IabJdefault#f");
	}
}

// Iab#fを実装しなければならない、Jstatic#fはstatic
class IabJstatic implements Iab, Jstatic {
	@Override
	public void f() {
		System.out.println("IabJstatic#f");
	}
}

//------------------------------------------------------------------------------

// Idefault#fを選択するかJ#fを実装しなければならない
class IdefaultJ implements Idefault, J {
	@Override
	public void f() {
		System.out.print("\t"); Idefault.super.f();
		System.out.println("IdefaultJ#f");
	}
}

// Idefault#fを選択するかJab#fを実装しなければならない
class IdefaultJab implements Idefault, Jab {
	@Override
	public void f() {
		System.out.print("\t"); Idefault.super.f();
		System.out.println("IdefaultJab#f");		
	}
}

// Idefault#fを選択するかJdefault#fを選択しなければならない
class IdefaultJdefault implements Idefault, Jdefault {
	@Override
	public void f() {
		System.out.print("\t"); Idefault.super.f();
		System.out.print("\t"); Jdefault.super.f();
		System.out.println("IdefaultJdefault");
	}
}

// Idefault#fデフォルトを流用、Jstatic#fはstatic
class IdefaultJstatic implements Idefault, Jstatic {
}

//------------------------------------------------------------------------------

// Istatic#fはstatic、J#fを実装しなければならない
class IstaticJ implements Istatic,J {
	@Override
	public void f() {
		System.out.println("IstaticJ#f");
	}
}

// Istatic#fはstatic、Jab#fを実装しなければならない
class IstaticJab implements Istatic, Jab {
	@Override
	public void f() {
		System.out.println("IstaticJab#f");
	}
}

// Istatic#fはstatic、Jdefault#fデフォルトを流用
class IstaticJdefault implements Istatic, Jdefault {
}

// Istatic#fはstatic、Jstatic#fはstatic。インスタンスメソッドfは無い
class IstaticJstatic implements Istatic, Jstatic {	
}

//------------------------------------------------------------------------------

// S#fを流用
class SI extends S implements I {}

//S#fを流用
class SIab extends S implements Iab {}

//S#fを流用
class SIdefault extends S implements Idefault {}

//S#fを流用
class SIstatic extends S implements Istatic {}

//==============================================================================

public class Ch1Ex11 {
	public static void main(String[] args) {
		I i;
		J j;
		Iab iab;
		Jab jab;
		Idefault idef;
		Jdefault jdef;

		System.out.println("IJ");
		i = new IJ();
		i.f();
		System.out.println();
		
		System.out.println("IJab");
		i = new IJab();
		i.f();
		System.out.println();
		
		System.out.println("IJdefault");
		jdef = new IJdefault();
		jdef.f();	// IJdefault#fが呼び出される
		System.out.println();
		
		System.out.println("IJstatic");
		i = new IJstatic();
		i.f();
		//IJstatic.f();	// <- C++のような呼び出しはできない
		Jstatic.f();
		System.out.println();
		
		System.out.println("------------------------------");

		System.out.println("IabJ");
		iab = new IabJ();
		iab.f();
		System.out.println();
		
		System.out.println("IabJab");
		iab = new IabJab();
		iab.f();
		System.out.println();
		
		System.out.println("IabJdefault");
		jdef = new IabJdefault();
		jdef.f();
		System.out.println();
		
		System.out.println("IabJstatic");
		iab = new IabJstatic();
		iab.f();
		//IJstatic.f();	// <- C++のような呼び出しはできない
		Jstatic.f();
		System.out.println();

		System.out.println("------------------------------");

		System.out.println("IdefaultJ");
		idef = new IdefaultJ();
		idef.f();
		System.out.println();
		
		System.out.println("IdefaultJab");
		idef = new IdefaultJab();
		idef.f();
		System.out.println();
		
		System.out.println("IdefaultJdefault");
		idef = new IdefaultJdefault();
		idef.f();
		System.out.println();
		
		System.out.println("IdefaultJstatic");
		idef = new IdefaultJstatic();
		idef.f();
		//IJstatic.f();	// <- C++のような呼び出しはできない
		Jstatic.f();
		System.out.println();
		
		System.out.println("------------------------------");		
		
		System.out.println("IstaticJ");
		Istatic.f();
		j = new IstaticJ();
		j.f();
		System.out.println();
		
		System.out.println("IstaticJab");
		Istatic.f();
		jab = new IstaticJab();
		jab.f();
		System.out.println();
		
		System.out.println("IstaticJdefault");
		Istatic.f();
		jdef = new IstaticJdefault();
		jdef.f();
		System.out.println();
		
		System.out.println("IstaticJstatic");
		//IstaticJstatic.f();
		Istatic.f();
		Jstatic.f();
		System.out.println();

		System.out.println("------------------------------");
		
		System.out.println("SI");
		i = new SI();
		i.f();
		System.out.println();
		
		System.out.println("SIab");
		iab = new SIab();
		iab.f();
		System.out.println();
		
		System.out.println("SIdefault");
		idef = new SIdefault();
		idef.f();
		System.out.println();
		
		System.out.println("SIstatic");
		new SIstatic().f();
		System.out.println();

		System.out.println("------------------------------");
	}
}
