<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<nav class="grey lighten-5"> <a href="#!"
		class="brand-logo right red-text">C<span class="blue-text">to</span>C
	</a> <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i
		class="large material-icons red-text">menu</i></a>
	<ul class="hide-on-med-and-down ">
		<li>
			<form id="logoutForm" method="POST" action="/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form> <a href="#" onclick="document.getElementById('logoutForm').submit()">Logout</a>
		</li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
	</nav>

	<ul class="sidenav" id="mobile-demo">
		<li>
			<form id="logoutForm" method="POST" action="/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form> <a href="#" onclick="document.getElementById('logoutForm').submit()">Logout</a>
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
						<img src="${currentUser.profilePic }" alt="picture of ${currentUser.name }" class="circle responsive-img" />
					</div>
					<div class="col s6 offset-s1">
						<h6>
							<b><c:out value="${currentUser.name}" /></b>
						</h6>
						<h6>
							<c:out value="${currentUser.city }, ${currentUser.state }" />
						</h6>

					</div>
				</div>
				<div class="divider red"></div>
				<p class="center-align">
					<a href="#edit" class="grey-text modal-trigger"> Edit Profile <i
						class="tiny material-icons grey-text">build</i>
					</a>
				</p>
			</div>
		</div>

		<div id="edit" class="modal">
			<div class="modal-content">
				<h4>Upload a profile picture</h4>
				<form action="/upload?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
					<div class="input-field">
						<input type="file" name="file" id="pic" />
					</div>
			<div class="modal-footer">
				<button class="btn" type="submit">upload</button>
			</div>
				</form>
			</div>
		</div>


		<div class="row">
			<div class="col s12 card">
				<h5 class="center-align">Candidates</h5>
				<ul class="collection  z-depth-1">
					<li class="collection-item avatar"><img src=""
						alt="candidate picture" class="circle"> <span class="title">Shelby
							Mirziteh</span>
						<p>
							People's Party <br> Seattle, WA
						</p> <a href="#!" class="secondary-content"><i
							class="material-icons grey-text">cancel</i></a></li>
					<li class="collection-item avatar"><img src=""
						alt="candidate picture" class="circle"> <span class="title">Amirah
							Ziada</span>
						<p>
							People's Party <br> Seattle, WA
						</p> <a href="#!" class="secondary-content"><i
							class="material-icons grey-text">cancel</i></a></li>
				</ul>
			</div>
			
		</div>

		<div class="row">
			<div class="col s12 card">
				<h5 class="center-align">Concerns</h5>
				<ul class="collection  z-depth-1">
					<c:forEach items="${issues }" var="issue">
						<li class="collection-item title">
						<span class="title"><c:out value="${issue.topic}"/></span>
							
							<a href="#!" class="secondary-content"><i
							class="material-icons grey-text">cancel</i></a>
						<p>
							<c:out value="${issue.content}"/>
						</p>
						</li>
					</c:forEach>
				</ul>
				<div class="divider red"></div>
				<p class="center-align">
					<a href="#addIssue" class=" modal-trigger blue-text"><i class="material-icons blue-text">add_box</i>
					
					</a>
				</p>
			</div>
		</div>
		
		<div id="addIssue" class="modal">
			<div class="modal-content">
				<h4>Raise a new Issue</h4>
				<form action="/addIssue?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="newIssue">
				<div class="input-field">
					<input type="text" name="topic" id="topic" />
					<label for="topic">Topic</label>
				</div>
					<div class="input-field">
						<textarea class="materialize-textarea" id="content" name="content"></textarea>
						<label for="content">Content</label>
					</div>
			<div class="modal-footer">
				<button class="btn" type="submit">Submit</button>
			</div>
				</form>
			</div>
		</div>



	</div>









	<script>
		$(document).ready(function() {
			$('.sidenav').sidenav();
			$('.modal').modal();
		});
	</script>


</body>
</html>