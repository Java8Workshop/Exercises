package com.tasktoys.java8ws.mrbearing.ch2.ex5;

import java.util.stream.Stream;

public class InfStream {

    
    public static Stream<Long> createInfintStream(long a,long c,long m, long seed){
        return Stream.iterate(seed, (n -> (a+n+c)%m ));
    }
    
    public static void main(String[] args) {
        
        Stream<Long> infstream = createInfintStream(
                25214903917L, 11,
                (long) Math.pow(2, 48),
                System.currentTimeMillis());
        System.out.println("valuse...");
        infstream.limit(5).forEach(System.out::println);
    }

}
