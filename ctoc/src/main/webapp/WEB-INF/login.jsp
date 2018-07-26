<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="Connecting Constituents to candidates">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login CtoC</title>
</head>
<body class="blue lighten-2">
	<div class="container">
		<div class="section"></div>
		<div class="row">
			<div
				class="col s12 m8 offset-m1 l5 offset-l3 card unchecked grey lighten-4">
				<div class="section">
					<c:if test="${logoutMessage != null}">
						<c:out value="${logoutMessage}" ></c:out>
					</c:if>
					<h4 class="center-align">Login</h4>
					<c:if test="${errorMessage != null}">
						<p><c:out value="${errorMessage}" /></p>
					</c:if>
					<form method="POST" action="/login">
						<div class="input-field">
							<input type="email" id="email" name="username" /> <label
								for="email">Email</label>
						</div>
						<div class="input-field">
							<input type="password" id="password" name="password" /> <label
								for="password">Password</label>
						</div>
						<div class="input-field">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
						<button class="btn red" type="submit">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>