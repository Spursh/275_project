<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="text-align: center;">
<h1>USER REGISTRATION</h1><br><br>
<form method="post" action="/275_lab2/user">
First Name&nbsp; &nbsp;<input type="text" name ="firstname" />
Last Name &nbsp; &nbsp; <input type="text" name="lastname"/>
Title &nbsp; &nbsp;<input type="text" name="title"/><br><br><br>
Address Assigned to this User<br><br>
Street &nbsp; &nbsp;<input type="text" name="street"/>
City &nbsp; &nbsp;<input type="text" name="city"/><br><br>
State &nbsp; &nbsp;<input type="text" name="state"/>
Zip &nbsp; &nbsp;<input type="text" name="zip"/>
<br><br><br>
<!-- Phone <input type="text" id="phone"> -->
&nbsp; &nbsp;&nbsp; &nbsp;<button type="submit" value="createUser">Create User</button>
</form>
</body>
</html>