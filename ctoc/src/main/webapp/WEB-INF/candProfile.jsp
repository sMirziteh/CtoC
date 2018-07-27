<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta name="description" content="Connecting Constituents to candidates">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- Compiled and minified JavaScript -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"
	type="text/javascript"></script>

<title>Candidate Profile</title>

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
			<li>
		<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    	</form>
	        <a href="#" onclick="document.getElementById('logoutForm').submit()">Logout</a>
		</li>
			<li><a href="#">About</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<ul class="sidenav" id="mobile-demo">
		<li>
		<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    	</form>
	        <a href="#" onclick="document.getElementById('logoutForm').submit()">Logout</a>
		</li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
	
	<div class="container">
		<div class="section"></div>
		<div class="row">
			<div class="col s12 card">
				<div class="row">
					<div class="section col s5">
						<br />
						<img src="${candidate.profilePic}" alt="picture of ${candidate.name }" class="circle responsive imgage" />
					
					</div>
					<div class="col s6 offset-s1">
						<h6><b><c:out value="${candidate.name}"/></b></h6>
						<h6><c:out value="${candidate.city }, ${candidate.state }"/></h6>
						<h6><c:out value="${candidate.pparty}"/></h6>
						<h6>District <c:out value="${candidate.district}"/></h6>
						<h6><c:out value="${candidate.website}"/></h6>
						<h6><c:out value="${candidate.facebook}"/></h6>
						<h6><c:out value="${candidate.linkedin}"/></h6>
						<h6><c:out value="${candidate.instagram}"/></h6>
						
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col s12 card">
				<h5 class="center-align">Platform</h5>
				<ul class="collection  z-depth-1">
					<li class="collection-item"> Tacimates percipitur sadipscing mel eu, ea putant bonorum definitiones duo.</li>
					<li class="collection-item"> Tacimates percipitur sadipscing mel eu, ea putant bonorum definitiones duo.</li>
					<li class="collection-item"> Tacimates percipitur sadipscing mel eu, ea putant bonorum definitiones duo.</li>
					<li class="collection-item"> Tacimates percipitur sadipscing mel eu, ea putant bonorum definitiones duo.</li>
				</ul>
			</div>
		</div>
		
		<div class="row">
			<div class="col s12 card">
				<h5 class="center-align">Biography</h5>
				<p class="flow-text">
				Lorem ipsum dolor sit amet, ne ius tempor voluptua, ad odio definitiones per. Eam id ridens adipisci, sed detraxit instructior id. At eam choro legendos. Ea eum legendos perpetua, nec cetero accusata liberavisse ad. Ut nec offendit conceptam. Affert ornatus instructior an pro, cu consetetur vituperatoribus has.
				</p>
			</div>
		</div>

		<div class="row">
			<div class="col s12 card">
				<h5 class="center-align">Education / involvement</h5>
				<p class="flow-text">
				Lorem ipsum dolor sit amet, ne ius tempor voluptua, ad odio definitiones per. Eam id ridens adipisci, sed detraxit instructior id. At eam choro legendos. Ea eum legendos perpetua, nec cetero accusata liberavisse ad. Ut nec offendit conceptam. Affert ornatus instructior an pro, cu consetetur vituperatoribus has.
				</p>
			</div>
		</div>
		
		
		
	</div>
	
	
	
	
	
	
	
	
	
	<script>
	
	 $(document).ready(function(){
		    $('.sidenav').sidenav();
			$('.modal').modal();

		  });
	</script>
	
	
</body>
</html>