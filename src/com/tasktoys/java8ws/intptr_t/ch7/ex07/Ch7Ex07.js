var ProcessBuilder = Java.type('java.lang.ProcessBuilder');
var Process = Java.type('java.lang.Process');
var BufferedReader = Java.type('java.io.BufferedReader');
var InputStreamReader = Java.type('java.io.InputStreamReader');

var pb = new ProcessBuilder();
pb.command('/bin/sh', '-c', 'find . | grep -v class | sort');
var proc = pb.start();

var istream = proc.getInputStream();
var reader = new BufferedReader(new InputStreamReader(istream));
var str;
while((str = reader.readLine()) != null){
    print(str);
}
reader.close();