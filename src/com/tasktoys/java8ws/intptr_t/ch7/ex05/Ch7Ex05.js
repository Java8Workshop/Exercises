function LoggingArrayList(){
    var ArrayList = Java.type('java.util.ArrayList')
    var ArrayListBase = Java.extend(ArrayList)
    var self = new ArrayListBase() {
        add: function(x){
            print('Adding' + x)
            return Java.super(self).add(x)
        }
    };
    Object.bindProperties(this, self); // Nashornの拡張機能、LogingArrayList(this)にselfを割り付け
    return this;
};

var x = new LoggingArrayList()
var y = new LoggingArrayList()

x.add(1)
y.add(10)

print(x)
print(y)