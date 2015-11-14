/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

function createMyArrayList() {
  return new (Java.extend(java.util.ArrayList)) {
    add: function(x) {
      print('Adding ' + x);
      return Java.super(arr).add(x);
    }
  }
}
var arr = createMyArrayList();
arr.add("foo")
arr.add("bar")
arr.add("baz")
print(arr)
