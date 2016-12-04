<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>USER UPDATION FORM</h1>
<form id="updateuserform" method="post">
First Name&nbsp; &nbsp;<input type="text" id="name" name ="firstname" value ="${user.firstname}"/>
Last Name &nbsp; &nbsp;<input type="text" id="last" name="lastname" value ="${user.lastname}"/>
Title <input type="text" id="titleuser" name="title" value = "${user.title}"/><br><br>
<h4>Address</h4><br>
Street &nbsp; &nbsp; <input type="text" id="streetaddr" name="street" value = "${user.address.street}"/>
City &nbsp; &nbsp;<input type="text" id="usercity" name="city" value = "${user.address.city}"/><br><br>
State &nbsp; &nbsp;<input type="text" id="userstate" name="state" value = "${user.address.state}"/>
Zip &nbsp; &nbsp;<input type="text" id="userzip" name="zip"value = "${user.address.zip}"/> 
<input type = "hidden" id="userid" name = "userId" value ="${user.id}">
<button type="submit" value="updateUser" onclick="updateUserDetails()">Update User Details</button>
</form>

<h3>List of Phone Numbers Assigned to this user</h3>

<c:forEach items="${user.phones}" var="phonesAssignedToUser">
        	<br> 
        	${phonesAssignedToUser}
</c:forEach> 

 <script>
function updateUserDetails() {
	var userid = document.getElementById("userid").value;
	var name = document.getElementById("name").value;
	var last = document.getElementById("last").value;
	var title = document.getElementById("titleuser").value;
	var street = document.getElementById("streetaddr").value;
	var city = document.getElementById("usercity").value;
	var state = document.getElementById("userstate").value;
	var zip = document.getElementById('userzip').value;
	//var formaction = $('#updateuserform').attr('action');
	//alert(formaction);
	var userform = "/275_lab2/user/" + userid +"?firstname="+name+"&lastname="+last+"&title="+title+"&street="+street+"&city="+city+"&state="+state+"&zip="+zip;
	//console.log("/275_lab2/------------------------->"+userform);
	$("#updateuserform").attr("action",userform);
	
}
</script>
<button  value="deleteUser" onclick="deleteUser()">Delete this User from Database</button>
</body>

<script>
function deleteUser(){
	
$.ajax({
	
	url: '/275_lab2/user/${user.id}',
    type: 'DELETE',
    success: function(result) {
    	window.location.assign("/275_lab2/user");
       },
	  error: function(err) { alert('This is user is deleted');  
	 window.location.assign("/275_lab2/user");}
});
}
</script>
</html>