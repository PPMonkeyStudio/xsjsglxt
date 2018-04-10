function ContrastFingerPrintGetBirth(){
	var input_suspecter_identity=document.getElementById("input_suspecter_identity");
	var input_suspecter_identityValue=input_suspecter_identity.value.trim();
	var input_suspecter_birthday=document.getElementById("input_suspecter_birthday");
	var strRegExp=/(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(strRegExp.test(input_suspecter_identityValue)==true){
			input_suspecter_birthday.value=input_suspecter_identityValue.substr(6,4)+"-"+input_suspecter_identityValue.substr(10,2)+"-"+input_suspecter_identityValue.substr(12,2);
		} 
		else{
			toastr.error("身份证号输入不合法！");
			return false;
		} 
	
}