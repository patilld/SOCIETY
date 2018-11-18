jQuery(function() {
	jQuery( "#socLicenseStartDate" ).datepicker({dateFormat: 'dd/mm/yy', changeYear: true,
		firstDay: 1,
		yearRange: '1950:2050'
	});
	jQuery( "#socLicenseEndDate" ).datepicker({dateFormat: 'dd/mm/yy', changeYear: true,
		firstDay: 1,
		yearRange: '1950:2050'
	});
});

function validateForm() {
	var socNameValue = $('#socName').val();
	
	if(socNameValue == null || socNameValue == "") {
		alert("Please enter Society name");
		return false;
	}
}