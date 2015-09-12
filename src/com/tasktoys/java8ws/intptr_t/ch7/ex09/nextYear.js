var age = (function(){
    if($ARG.length > 0){ return $ARG[0]; }
    if('AGE' in $ENV){ return $ENV['AGE']; }
    return readLine('how old r u: ');
})();
var nextYear = parseInt(age) + 1;
print('Next year, you will be ' + nextYear);