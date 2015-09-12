var Files = Java.type('java.nio.file.Files');
var Paths = Java.type('java.nio.file.Paths');
var Arrays = Java.type('java.util.Arrays');
var StandardCharsets = Java.type('java.nio.charset.StandardCharsets');
var JString = Java.type('java.lang.String');
var Collectors = Java.type('java.util.stream.Collectors')

var contents = new JString(Files.readAllBytes(Paths.get('out/alice.txt')), StandardCharsets.UTF_8);
var words = Arrays.asList(contents.split(/[\W]+/));               

var less12List = words.stream()
    .filter(function(w){ return w.length() > 12 })
    .collect(Collectors.toSet()) 
    .stream()
    .sorted()
    .collect(Collectors.toList());
print(less12List);
