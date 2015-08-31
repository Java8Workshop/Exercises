var str1 = new String('abc') // Stringオブジェクト
var str11 = str1.substr(-2)
var str2 = String('def')     // コンストラクタ関数(thisを返してくれるようなので使える)
var str22 = str2.substr(-2)
var str3 = 'ghi';            // 文字列リテラル
var str33 = str3.substr(-2)

print(str11.getClass()) // -> class java.lang.String
print(str22.getClass()) // -> class java.lang.String
print(str33.getClass()) // -> class java.lang.String

print(java.lang.String.class.cast(str11)) // -> bc
print(java.lang.String.class.cast(str22)) // -> ef
print(java.lang.String.class.cast(str33)) // -> hi

//print(str1.getClass()) // -> Javascript 'object'
print(str2.getClass()) // -> class java.lang.String
print(str3.getClass()) // -> class java.lang.String

//print(java.lang.String.class.cast(str1)) // java.lang.ClassCastException
print(java.lang.String.class.cast(str2)) // -> def
print(java.lang.String.class.cast(str3)) // -> ghi

print(typeof(str1) + " : " + typeof(str2) + " : " + typeof(str3))
print(typeof(str11) + " : " + typeof(str22) + " : " + typeof(str33))
