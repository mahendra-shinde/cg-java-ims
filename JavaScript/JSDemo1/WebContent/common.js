/**
 * 
 */
function doSum(x,y){
	alert("Sum is "+ (x+y));
}

function myFun(x){
	alert("This function has "+myFun.arguments.length+ " arguments");
	alert("But, It was declared to take only "+myFun.length)
}
function doMath(operator){
	if(doMath.arguments.length<3){
		alert("Insufficient parameters");
		return; //End of Current function
	}
	if(operator === '+' || operator === '-' || operator === '*' || operator === '/'){
		expr = '';	//Creating an empty string expression
		for(i=1;i<doMath.arguments.length;i++){
			n = parseFloat(doMath.arguments[i]); //Parse as FLOAT
			expr += n;
			//DO NOT APPEND OPERATOR AFTER LAST ELEMENT!
			if(i != doMath.arguments.length-1){
				expr += operator;
			}
		}
		ans = eval(expr);
		alert("Final Answer is "+ans);
	}
	else{
		alert("Invalid operator found!, expecting any one of +,-,*,/ ")
	}
}