<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Search Book</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "abc",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#title" ).autocomplete({
      source: availableTags
    });
  } );
  </script>
</head>

<body>
	<div class="container-fluid">
		<div class="jumbotron">
			<h2>Search a Book</h2>			
		</div>
	</div>
	<div class="container-fluid" id="register">
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="span8">
					<form action="/275_lab2/book/searchBook" method="post">
						<div class="ui-widget">
  							<label for="title">Enter the title of the Book</label>
  							<input type="text" class="form-control" id="title" name="title">
						</div>
						
						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
 
</body>
</html>

