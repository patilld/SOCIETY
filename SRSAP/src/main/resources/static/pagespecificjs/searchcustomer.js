function validateCriteria() {
	var cacNumber = $("#cacNumber").val();
	var cdeFirstName = $("#cdeFirstName").val();
	var cdeLastName = $("#cdeLastName").val();
	
	if((cacNumber == null || cacNumber == "") && (cdeFirstName == null || cdeFirstName =="") && (cdeLastName == null || cdeLastName == "")) {
		alert("Please enter any field to procced");
	}
	else {
		document.frm1.submit();
	}
}