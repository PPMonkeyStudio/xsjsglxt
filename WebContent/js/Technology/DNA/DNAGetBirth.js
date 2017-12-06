function DNAGetBirth(){
	var input_IDCard=document.getElementById("input_IDCard");
	var input_IDCardValue=input_IDCard.value.trim();
	var input_birth=document.getElementById("input_birth");
	var strRegExp=/(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(strRegExp.test(input_IDCardValue)==true){
			input_birth.value=input_IDCardValue.substr(6,4)+"-"+input_IDCardValue.substr(10,2)+"-"+input_IDCardValue.substr(12,2);
		}
		else{
			toastr.error("身份证号输入不合法！");
			return false;
		} 
	
}