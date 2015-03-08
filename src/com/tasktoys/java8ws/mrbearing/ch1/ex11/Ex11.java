package com.tasktoys.java8ws.mrbearing.ch1.ex11;

/*
 *　インターフェースI,Jのf()メソッドが両方抽象の場合、Bothクラスでｆの実装をする必要がある
 *　
 *　I,Jのf()メソッドがともにstaticの場合 Bothクラスでの実装の必要はない、
 *　しかし、メンバとしてBothクラスに実装されるわけではない。あくまでI,Jそれぞれのstaticとして実装される。
 * 
 * 次の2つの場合にはBothクラスでf()メソッドをオーバーライドしないと、衝突が起きてコンパイルエラーとなる
 *　　・どちらかの記述がdefaultと抽象の場合
 *  ・どちらもdefaultで実装されている場合
 * この場合はBothクラスのメンバとして呼び出される。 
 * 
 * 片方がstatic,もう片方はdefautlで記述されている場合には、defaultで実装されている方のメソッドが
 * Bothクラスのメンバメソッドとなる。
 */
interface I {
   //public void f();
  /* */
  public default void f() {
    System.out.println("f in I");
  }
  /* */

  /* *
    public static void f(){ 
      System.out.println("f in I"); 
      }
    
   /* */
}

interface J {
  // public void f();

  public default void f() {
    System.out.println("f in J");
  }

  /* *
  public static void f() {
    System.out.println("f in I");
  }

  /* */
}


class Both implements I, J {
    /* */
    public void f(){
      System.out.println(" f in Both");
    }
    /* */
}

//-----------------------------------------------------------
//----スーパークラス　SをBoth2クラスが継承しインターフェースI2を実装した場合----------
/*
 * インターフェースI2のf()メソッドが抽象、static、defaultのどれであってもBothクラスでオーバーライドする必要はない
 * defaultで実装されていても、Both.f()はスーパークラスSが実行される。
 * 
 */

class S {
  public void f(){
    System.out.println("f in S" );
  }
}

interface I2{
  //public void f();
  
  /* *
  
  public static void f(){
    System.out.println("f in i statc ");
  }
  
  /* */
  public default void f(){
    System.out.println("f in i default ");
  }
  
  /* */
}

class Both2 extends S implements I2{
  
}



public class Ex11 {
  public static void main(String[] args) {
    
    
    Both b = new Both();
    b.f();
    
    Both2 b2 = new Both2();
    b2.f();
  }

}
