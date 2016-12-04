<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
First Name<input type="text" id="name" name ="firstname" value ="${user.firstname}"/><br>
Last Name <input type="text" id="last" name="lastname" value ="${user.lastname}"/><br>
Title <input type="text" id="titleuser" name="title" value = "${user.title}"/><br>
Address<br>
Street<input type="text" id="streetaddr" name="street" value = "${user.address.street}"/>
City<input type="text" id="usercity" name="city" value = "${user.address.city}"/>
State<input type="text" id="userstate" name="state" value = "${user.address.state}"/>
Zip<input type="text" id="userzip" name="zip"value = "${user.address.zip}"/> 
</body>
</html>