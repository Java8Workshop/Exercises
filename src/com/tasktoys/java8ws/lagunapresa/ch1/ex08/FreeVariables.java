package com.tasktoys.java8ws.lagunapresa.ch1.ex08;

import java.util.ArrayList;
import java.util.List;

// これは正当なコードでしょうか => Yes
// 各ラムダ式がキャプチャする String オブジェクトは別々のオブジェクト("Peter", "Paul", "Marry")
public class FreeVariables {

    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Marry"};
        List<Runnable> runners1 = new ArrayList<>();
        List<Runnable> runners2 = new ArrayList<>();

        for (String name : names)
            runners1.add(() -> System.out.println(name));

        for (int i = 0; i < names.length; i++) {
            String name = names[i];// i は実質的finalでないのでラムダ式の中に name[i] は書けない
            runners2.add(() -> System.out.println(name));
        }
        runners1.forEach(Runnable::run);
        runners2.forEach(Runnable::run);
    }

}
