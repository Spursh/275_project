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
			<h2 id="title">User Registration</h2>			
		</div>
	</div>
	<div class="container-fluid" id="register">
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="span8">
					<form action="continue" method="post">
						<div class="form-group" >
							<label for="firstname">First Name</label> <input type="text"
							class="form-control" name="fName">
						</div>
						<div class="form-group" >
							<label for="lastname">Last Name</label> <input type="Text"
							class="form-control" name="lName" >
						</div>
						<div class="form-group" >
							<label for="email">Email</label> <input type="Text"
							class="form-control" name="email">
						</div>
						
						<div class="form-group" >
							<label for="password">Password</label> <input type="password"
							class="form-control" name="password" >
						</div>
						<div class="form-group" >
							<label for="universityid">University ID</label> <input type="text"
							class="form-control" name="univid">
						</div>
						
						<button type="submit" value="Continue" class="btn btn-default" name="action">Submit Details</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>