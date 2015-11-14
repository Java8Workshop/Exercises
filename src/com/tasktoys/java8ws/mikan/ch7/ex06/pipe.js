/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

 function pipe() {
   var result;
   for (i = 0; i < arguments.length; i++) {
       result = $EXEC(arguments[i], result);
   }
   return result;
 }

//print(pipe('find .', 'grep -v class', 'sort'));
print(pipe('find .', 'grep .js', 'sort'));
