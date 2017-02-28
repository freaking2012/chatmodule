
$(document).ready(function() {
	var rootURL = "http://localhost:8080/chat/rest";

    $('#login-form-link').click(function(e) {
		showLoginForm(e);
		
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
	$('#register-submit').click(function(e) {
		createUser();
		return false;
	});
	
	$('#login-submit').click(function(e) {
		login();
		return false;
	});
	
	function showLoginForm(e)
	{
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$('#login-form-link').addClass('active');
	}
	
	function createUser()
	{
		console.log('createUser');
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: rootURL+"/user",
			dataType: "json",
			data: registerFormToJSON(),
			success: function(data, textStatus, jqXHR){
				showLoginForm();
				alert("You've been registered successfully. Please login with your credentials.");
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert('createUser error: ' + textStatus);
			}
		});
		
	}
	
	function login()
	{
		console.log('login');
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: rootURL+"/login",
			dataType: "json",
			data: loginFormToJSON(),
			success: function(data, textStatus, jqXHR){
				location.href = "converse.html";
			},
			error: function(jqXHR, textStatus, errorThrown){
				location.href = rootURL;
				alert('createUser error: ' + textStatus);
			}
		});
		
	}
	
	function registerFormToJSON() {
		return JSON.stringify({
			"name": $('#idName').val(), 
			"emailId": $('#idEmailId').val(),
			"phoneNumber": $('#idPhoneNumber').val(),
			"password": $('#idPassword').val()
			});
	}
	
	function loginFormToJSON() {
		return JSON.stringify({
			"emailId": $('#idEmailId').val(),
			"password": $('#idPassword').val()
		});
	}

});
