<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin-top: 10%;
    	margin-left: 40%;
    	margin-right: 20%;
    	margin-bottom: 40%;
    }
    .bottom-ex{
    margin-bottom: 40%;
    }
</style>
</head>
<body>
<nav class="navbar navbar-dark bg-primary" >
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" style="background-color: #e3f2fd" href="Login.html">BullPost</a>
				<a class="navbar-brand" style="background-color: #e3f2fd" href="viewPosts?method=get">View All Posts</a>
				
				<a class="navbar-brand" style="background-color: #e3f2fd" href="viewPosts?method=post">View Your Posts</a>
				
					<a class="navbar-brand" style="background-color: #e3f2fd" href="profile?method=get">Write Posts</a>	
				<a class="navbar-brand" style="background-color: #e3f2fd" href="profile?method=post&Username=">Profile</a>
				
				<a class="navbar-brand" style="background-color: #e3f2fd" href="Register?method=post">Logout</a>
			</div>
		</div>
		
	</nav>
${message}
</body>
</html>