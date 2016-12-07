<html>
<head>
	<title>User Registration</title>
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
<body>
	<div class="container-fluid">
		<div class="jumbotron">
			<h2 id="title">Enter Book Details</h2>	
				<input type="text" name="id" value="${user.userid}" />	
		</div>
	</div>
	<div class="container-fluid" id="register">
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="span8">
					<form action="/275_lab2/book/createBook" method="post">
					
						<div class="form-group" >
							<label for="bookid">Book ID</label> <input type="text"
							class="form-control" id="bookid" name="bookid" placeholder="Book ID">
						</div>
						<div class="form-group" >
							<label for="author">Author</label> <input type="Text"
							class="form-control" id="author" name="author" >
						</div>
						<div class="form-group" >
							<label for="title">Title</label> <input type="Text"
							class="form-control" id="title" name="title">
						</div>
						
						<div class="form-group" >
							<label for="callnum">Call Number</label> <input type="text"
							class="form-control" id="callnum" name="callnum" >
						</div>
						<div class="form-group" >
							<label for="publisher">Publisher</label> <input type="text"
							class="form-control" id="publisher" name="publisher">
						</div>
						<div class="form-group" >
							<label for="year">Year </label> <input type="text"
							class="form-control" id="year" name="year" >
						</div>
						<div class="form-group" >
							<label for="location">Location </label> <input type="text"
							class="form-control" id="location" name="location" >
						</div>
						<div class="form-group" >
							<label for="copies">Copies </label> <input type="text"
							class="form-control" id="copies" name="copies">
						</div>
						<div class="form-group" >
							<label for="status">Status </label> <input type="text"
							class="form-control" id="status" name="status">
						</div>
						<div class="form-group" >
							<label for="keywords">Keyword </label> <input type="text"
							class="form-control" id="keywords" name="keywords">
						</div>
						<button type="submit" class="btn btn-default">Submit Details</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>