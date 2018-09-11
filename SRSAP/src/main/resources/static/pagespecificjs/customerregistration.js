jQuery(function() {
	jQuery( "#cdDob" ).datepicker({dateFormat: 'dd/mm/yy', changeYear: true,
		firstDay: 1,
		yearRange: '1950:2050'
	});
	
	jQuery('#closebtn').click( function() { close() });
	$("#fromCurrent").hide();
	$('#openingFromCurrentMonth').change(function() {
        if(this.checked) {
            $("#fromStart").hide();
            $("#fromCurrent").show();
        }
        else {
        	 $("#fromStart").show();
             $("#fromCurrent").hide();
        }
    });
});

function validateForm() {
		var cdFirstNameValue = $('#cdFirstName').val();
		var cdLastNameValue = $('#cdLastName').val();
		var cdDobValue = $('#cdDob').val();
		var cdGenderValue = $('#cdGender').val();
		var addLine1Value = $('#addLine1').val();
		var addPostalCodeValue = $('#addPostalCode').val();
		var addMobileValue = $('#addMobile').val();
		var isEmpty = false;
		
		if(cdFirstNameValue == null || cdFirstNameValue == "") {
			alert("Please enter first name");
			isEmpty = true;
		}
		else if(cdLastNameValue == null || cdLastNameValue == "") {
			alert("Please enter last name");
			isEmpty = true;
		}
		else if(cdDobValue == null || cdDobValue == "") {
			alert("Please select date of birth");
			isEmpty = true;
		}
		else if(cdGenderValue == null || cdGenderValue == "") {
			alert("Please select gender");
			isEmpty = true;
		}
		else if(addLine1Value == null || addLine1Value == "") {
			alert("Please enter address line 1");
			isEmpty = true;
		}
		else if(addPostalCodeValue == null || addPostalCodeValue == "") {
			alert("Please enter postal code");
			isEmpty = true;
		}
		else if(addMobileValue == null || addMobileValue == "") {
			alert("Please enter mobile number");
			isEmpty = true;
		}
		
		if(isEmpty == true) { 
			return false;
		}
		else {
			showPopup();
		}
}

function showPopup(){
	jQuery('#block').fadeIn();
	jQuery('#accountContainer').fadeIn();
}

function close() {  
	jQuery('#block').fadeOut();
	jQuery('#accountContainer').fadeOut();  
}
