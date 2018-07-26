<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="Connecting Constituents to candidates">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Compiled and minified CSS -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>

<title>C to C</title>

<style>
	ul li a {
		color:#f44336;
	}
</style>
</head>
<body class="blue lighten-2">
	<nav class="grey lighten-5">
		<a href="#!" class="brand-logo right red-text">C<span class="blue-text">to</span>C</a>
		<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="large material-icons red-text">menu</i></a>
		<ul class="hide-on-med-and-down ">
			<li><a href="/login">Log in</a></li>
			<li><a href="/registration">Register</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<ul class="sidenav" id="mobile-demo">
		<li><a href="/login">Log in</a></li>
		<li><a href="/registration">Register</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
	
	<div class="container">
		<div class="section"></div>
		<div class="row">
				<div class="col s12 card blue-text text-darken-4">
					<h5 class="center-align"><a href="#" class="blue-text text-darken-4">See Candidates</a></h5>
				</div>
				<div class="col s12 card blue-text text-darken-4">
					<h5 class="center-align"><a href="#" class="blue-text text-darken-4">See Issues</a></h5>
				</div>
				<div class="section">
				<div class="col s12 card blue-text text-darken-4">
					<h5 class="center-align ">CtoC Mission</h5>
					<p class="center-align">Connect engaged citizens with engaging candidates</p>
					<h6 class="center-align"><b>Constituents</b></h6>
					<p class="center-align">View candidate biographies, political platform, and contact information</p>
					<p class="center-align">Raise concerns to candidates and other constituents</p>
					<h6 class="center-align"><b>Candidates</b></h6>
					<p class="center-align">Create informative profiles</p>
					<p class="center-align">Engage with your constituents by offering all of your contact information in one place</p>
					<p class="center-align">See your constituents' concerns and add them to your platform</p>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<script>
	
	 $(document).ready(function(){
		    $('.sidenav').sidenav();
		  });
	</script>
	
</body>
</html>