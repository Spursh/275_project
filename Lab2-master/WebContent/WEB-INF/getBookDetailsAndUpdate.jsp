<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Update Book Details</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script>
function deleteBook(){
	
$.ajax({
	
	url: '/275_lab2/book/${bookid}',
    type: 'DELETE',
    success: function(result) {
    	window.location.href("/book/createBook");
       },
	  error: function(err) { alert('This is user is deleted');  
	 window.location.href("/book/createBook");}
});
}
</script>
<body>
	<div class="container-fluid">
		<div class="jumbotron">
			<h2 id="title">Update User</h2>			
		</div>
	</div>
	<div class="container-fluid" id="register">
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="span8">
					<form action="/275_lab2/book/${newbook.bookid}" method="post">
						<div class="form-group" >
							<label for="bookid">Book ID</label>
							 <input type="text" class="form-control" id="bookid" name="bookid" value ='${newbook.bookid}'>
						</div>
						<div class="form-group" >
							<label for="author">Author</label> <input type="Text"
							class="form-control" id="author" name="author"  value ="${newbook.author}">
						</div>
						<div class="form-group" >
							<label for="title">Title</label> <input type="Text"
							class="form-control" id="title" name="title" value ="${newbook.title}">
						</div>
						
						<div class="form-group" >
							<label for="callnum">Call Number</label> <input type="text"
							class="form-control" id="callnum" name="callnum" value ="${newbook.callnum}" >
						</div>
						<div class="form-group" >
							<label for="publisher">Publisher</label> <input type="text"
							class="form-control" id="publisher" name="publisher" value ="${newbook.publisher}">
						</div>
						<div class="form-group" >
							<label for="year">Year </label> <input type="text"
							class="form-control" id="year" name="year" value ="${newbook.year}" >
						</div>
						<div class="form-group" >
							<label for="location">Location </label> <input type="text"
							class="form-control" id="location" name="location" value ="${newbook.location}" >
						</div>
						<div class="form-group" >
							<label for="copies">Copies </label> <input type="text"
							class="form-control" id="copies" name="copies" value ="${newbook.copies}">
						</div>
						<div class="form-group" >
							<label for="status">Status </label> <input type="text"
							class="form-control" id="status" name="status" value ="${newbook.status}">
						</div>
						<div class="form-group" >
							<label for="keywords">Keyword </label> <input type="text"
							class="form-control" id="keywords" name="keywords" value ="${newbook.keywords}">
						</div>
						<button type="submit" class="btn btn-default">Update</button>
					</form>
				</div>
				<button  value="deleteBook" onclick="deleteBook()">Delete this Book</button>
			</div>
		</div>
	</div>

</body>
</html>