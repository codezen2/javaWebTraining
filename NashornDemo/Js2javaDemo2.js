var StringBuffer = Java.type('java.lang.StringBuffer'); 

function doReverse(val){
	var sbuff = new StringBuffer(val);
	var res = sbuff.reverse();
	return res;
}

var result = doReverse("rama");
print(result);