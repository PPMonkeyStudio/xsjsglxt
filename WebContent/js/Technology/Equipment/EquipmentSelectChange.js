function EquipmentSelectChange(){
	var select_feature=document.getElementById("select_feature");
	var input_feature=document.getElementById("input_feature");
	if(select_feature.value=="其他"){
		input_feature.value="";
		input_feature.disabled="";
	}else{
		input_feature.value=select_feature.value;
		input_feature.disabled="disabled"; 
	}
	/*switch (select_feature.value) {
	case "不限":
		input_feature.value=select_feature.value;
		input_feature.disabled="disabled";
		break;
	case "痕迹":
		input_feature.value=select_feature.value;
		input_feature.disabled="disabled";
		break;
	case "法医":
		input_feature.value=select_feature.value;
		input_feature.disabled="disabled";
		break;
	case "影像":
		input_feature.value=select_feature.value;
		input_feature.disabled="disabled";
		break;
	case "技管":
		input_feature.value=select_feature.value;
		input_feature.disabled="disabled";
		break;

	default:
		input_feature.value="";
		input_feature.disabled="";
		break;
	}*/
}