var Integer = Java.type('java.lang.Integer'); 

function convertDecToBin(val){
	var res = Integer.toBinaryString(val);
	return res;
}

var result = convertDecToBin(25);
print(result);