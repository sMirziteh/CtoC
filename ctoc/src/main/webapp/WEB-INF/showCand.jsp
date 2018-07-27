<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<div class="col s12 card">
				<h5 class="center-align">Candidates</h5>
				<ul class="collection  z-depth-1">
					<c:forEach items="${candidates}" var="cand">
					<a href="/showCandidate/${cand.id }?${_csrf.parameterName}=${_csrf.token}" class="blue-text text-darken-4">
						<li class="collection-item avatar"><img src="${cand.profilePic }"
								alt="candidate picture" class="responsive image circle"> 
								<span class="title"><c:out value="${cand.name }"/></span>
									
								<p>
									<c:out value="${cand.city }, ${cand.state }"/>
								</p> <a href="#!" class="secondary-content"><i
									class="material-icons grey-text">favorite_border</i></a>
						</li>
					</a>
					</c:forEach>
					
				</ul>
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