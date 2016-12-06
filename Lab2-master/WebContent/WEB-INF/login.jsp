


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
			<h2 id="title">User Login</h2>			
		</div>
	</div>
	<div class="container-fluid" id="register">
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="span8">
					<form action="userLogin" method="post">
						<div class="form-group" >
							<label for="firstname">Email Address</label> <input type="text"
							class="form-control" name="email">
						</div>
						
						<div class="form-group" >
							<label for="password">Password</label> <input type="password"
							class="form-control" name="password" >
						</div>
						<button type="submit" value="Log in" class="btn btn-default" name="action">Log In</button>
					</form>
					
					<form action="userSignup" method="post">
						<div class="form-group" >
							<p><b>Don't have an account?</b></p>
							<p><b>Click Below to Sign Up</b></p>
						</div>

						<button type="submit" value="Sign Up" class="btn btn-default" name="action">Sign Up</button>
					</form>
					
					
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>