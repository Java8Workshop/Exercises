/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

var source = 'Musashi Kosugi' // JS String
print("source: " + source.getClass()) // J getClass() returns java.lang.String
var slice = source.slice(-6) // JS method
print("slice:  " + slice.getClass()) // J getClass() returns java.lang.String
var cast = java.lang.String.class.cast(slice)
print(cast) // "Kosugi"
