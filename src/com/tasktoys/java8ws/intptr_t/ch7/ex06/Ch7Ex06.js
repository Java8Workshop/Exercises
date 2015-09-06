function pipe(arg){
    var stdout = '';
    for(var i = 0; i < arguments.length; i++) {
        $EXEC(arguments[i], stdout);
        stdout = $OUT;
    }
}

pipe('find .', 'grep -v class', 'sort');
print($OUT);
