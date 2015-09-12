/*
jjs> var b = new java.math.BigInteger('1234567890987654321')
jjs> b
1234567890987654400
jjs> b.mod(java.math.BigInteger.TEN)
jjs> java.lang.String.format('%d', b)
1234567890987654321
jjs>
*/
var b = new java.math.BigInteger('1234567890987654321')
print(b)
print(b.mod(java.math.BigInteger.TEN))
print(java.lang.String.format('%d', b))
