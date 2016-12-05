<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Book Checkout Details</h1>
Author ${book.author}
Title ${book.title}
Publisher ${book.publisher}
Year ${book.year}
Location ${book.location}
<form action="/275_lab2/bookCheckout" method="post">
 <c:if test="${book.copies != 0}">
 	<button type="submit" value = "checkoutBook">Checkout</button>
 	<input type = "hidden" id="bookid" name = "bookid" value ="${book.bookid}">
 </c:if>
 </form>
 
</body>
</html>