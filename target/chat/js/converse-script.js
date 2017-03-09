$(document).ready(function(){
	
	var rootURL = "http://localhost:8080/chat/rest/converse";
	var userId = getParameterByName('id');
	var currentUser;
	var otherUsers;
	alert(userId);
	loadUser();
	loadOtherUsers();
		function loadUser()
	{
		console.log('loadCurrentUser');
		$.ajax({
		type: 'GET',
		url: rootURL + '/currentuser/' + userId,
		dataType: "json",
		success: function(data){
			
			console.log('currentuser success: ' + data.name);
			currentUser = data;
			alert("current User: "+currentUser.name);
		}
	});

		
	}

	function loadOtherUsers()
	{
		console.log('loadOtherUsers');
		$.ajax({
		type: 'GET',
		url: rootURL + '/otherusers/' + userId,
		dataType: "json",
		success: function(data){
			
			console.log('otherusers success: ');
			otherUsers = data == null ? [] : (data instanceof Array ? data : [data]);
			$.each( otherUsers, function( index,userDo ) {
  				alert( "other user name: "+userDo.name);
			});
		}
	});
		
	}



	function getParameterByName(name, url) {
    if (!url) {
      url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

});