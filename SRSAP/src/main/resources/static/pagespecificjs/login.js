jQuery(function() {

	$( "#frm1" ).submit(function( event ) {
		  var usernameValue = $("#username").val();
		  var passwordValue = $("#password").val();
		  if(usernameValue == null || usernameValue.trim() == '') {
			  alert("Username can not be empty");
			  event.preventDefault();
		  }
		  else if(passwordValue == null || passwordValue == '') {
			  alert("Password can not be empty");
			  event.preventDefault();
		  }
	});
	
});
