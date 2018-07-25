<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="Connecting Constituents to candidates">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Register for CtoC</title>
</head>
<body class="blue lighten-2">
	<div class="container">
	<div class="section"></div>
		<div class="row">
			<div class="col s12 m8 offset-m1 l5 offset-l3 card unchecked grey lighten-4">
				<div class="section">
					<h4 class="center-align">Register as a:</h4>
<!-- 					<div class="row"> -->
<!-- 						div.col.s11 -->
<!-- 					</div> -->
					<p class="center-align">
					<button class="btn red cand">Candidate</button>
					<button class="btn red constit">Constituent</button>					
					</p>
				</div>
			</div>
			
			<div class="col s12 m8 offset-m1 l5 offset-l3 card regform candidateForm grey lighten-5" style="display: none;">
				<div class="section">
					<p>
						<i class="tiny material-icons back">arrow_back</i>
						<h6 class="center-align">Candidate Sign-up</h6>
					</p>
					<div class="divider"></div>
					<form:form action="" method="post" modelAttribute="candidate">
						<div class="col s9 input-field">
							<form:input path="name" id="name" />
							<label for="name">Name</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="email" id="email" type="email"/>
							<label for="email">Email</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="city" id="city" type="text"/>
							<label for="city">City/Town</label>
						</div>
						<div class="col s9 input-field">
							
							<form:select path="state" id="state" class="browser-default">
								<option value="" disabled selected>State</option>
								<option value="AL">Alabama</option>
								<option value="AK">Alaska</option>
								<option value="AZ">Arizona</option>
								<option value="AR">Arkansas</option>
								<option value="CA">California</option>
								<option value="CO">Colorado</option>
								<option value="CT">Connecticut</option>
								<option value="DE">Delaware</option>
								<option value="DC">District Of Columbia</option>
								<option value="FL">Florida</option>
								<option value="GA">Georgia</option>
								<option value="HI">Hawaii</option>
								<option value="ID">Idaho</option>
								<option value="IL">Illinois</option>
								<option value="IN">Indiana</option>
								<option value="IA">Iowa</option>
								<option value="KS">Kansas</option>
								<option value="KY">Kentucky</option>
								<option value="LA">Louisiana</option>
								<option value="ME">Maine</option>
								<option value="MD">Maryland</option>
								<option value="MA">Massachusetts</option>
								<option value="MI">Michigan</option>
								<option value="MN">Minnesota</option>
								<option value="MS">Mississippi</option>
								<option value="MO">Missouri</option>
								<option value="MT">Montana</option>
								<option value="NE">Nebraska</option>
								<option value="NV">Nevada</option>
								<option value="NH">New Hampshire</option>
								<option value="NJ">New Jersey</option>
								<option value="NM">New Mexico</option>
								<option value="NY">New York</option>
								<option value="NC">North Carolina</option>
								<option value="ND">North Dakota</option>
								<option value="OH">Ohio</option>
								<option value="OK">Oklahoma</option>
								<option value="OR">Oregon</option>
								<option value="PA">Pennsylvania</option>
								<option value="RI">Rhode Island</option>
								<option value="SC">South Carolina</option>
								<option value="SD">South Dakota</option>
								<option value="TN">Tennessee</option>
								<option value="TX">Texas</option>
								<option value="UT">Utah</option>
								<option value="VT">Vermont</option>
								<option value="VA">Virginia</option>
								<option value="WA">Washington</option>
								<option value="WV">West Virginia</option>
								<option value="WI">Wisconsin</option>
								<option value="WY">Wyoming</option>
							</form:select>
						</div>
						<div class="col s9 input-field">
							<form:input path="zipcode" id="zip" type="text"/>
							<label for=zip>Zipcode</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="district" id="dis" type="number"/>
							<label for=dis>District</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="password" id="pw" type="password"/>
							<label for=pw>Password</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="passwordConfirmation" id="pwc" type="password"/>
							<label for="pwc">Confirm Password</label>
						</div>
						<div class="">
							<button class="btn red " type="submit">Submit</button>
							<br />
						</div>
					</form:form>
				</div>
			</div>
			<div class="col s12 m8 offset-m1 l5 offset-l3 card regform constituentForm grey lighten-5" style="display: none;">
				<div class="section">
				<p>
					<i class="tiny material-icons back">arrow_back</i>
					<h6 class="center-align">Constituent Sign-up</h6>
				</p>
					<div class="divider"></div>
					<form:form action="" method="post" modelAttribute="constit">
						<div class="col s9 input-field">
							<form:input path="name" id="name"/>
							<label for="name">Name</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="email" id="email" type="email"/>
							<label for="email">Email</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="city" id="city" type="text"/>
							<label for="city">City/Town</label>
						</div>
						<div class="col s9 input-field">
							
							<form:select path="state" id="state" class="browser-default">
								<option value="" disabled selected>State</option>
								<option value="AL">Alabama</option>
								<option value="AK">Alaska</option>
								<option value="AZ">Arizona</option>
								<option value="AR">Arkansas</option>
								<option value="CA">California</option>
								<option value="CO">Colorado</option>
								<option value="CT">Connecticut</option>
								<option value="DE">Delaware</option>
								<option value="DC">District Of Columbia</option>
								<option value="FL">Florida</option>
								<option value="GA">Georgia</option>
								<option value="HI">Hawaii</option>
								<option value="ID">Idaho</option>
								<option value="IL">Illinois</option>
								<option value="IN">Indiana</option>
								<option value="IA">Iowa</option>
								<option value="KS">Kansas</option>
								<option value="KY">Kentucky</option>
								<option value="LA">Louisiana</option>
								<option value="ME">Maine</option>
								<option value="MD">Maryland</option>
								<option value="MA">Massachusetts</option>
								<option value="MI">Michigan</option>
								<option value="MN">Minnesota</option>
								<option value="MS">Mississippi</option>
								<option value="MO">Missouri</option>
								<option value="MT">Montana</option>
								<option value="NE">Nebraska</option>
								<option value="NV">Nevada</option>
								<option value="NH">New Hampshire</option>
								<option value="NJ">New Jersey</option>
								<option value="NM">New Mexico</option>
								<option value="NY">New York</option>
								<option value="NC">North Carolina</option>
								<option value="ND">North Dakota</option>
								<option value="OH">Ohio</option>
								<option value="OK">Oklahoma</option>
								<option value="OR">Oregon</option>
								<option value="PA">Pennsylvania</option>
								<option value="RI">Rhode Island</option>
								<option value="SC">South Carolina</option>
								<option value="SD">South Dakota</option>
								<option value="TN">Tennessee</option>
								<option value="TX">Texas</option>
								<option value="UT">Utah</option>
								<option value="VT">Vermont</option>
								<option value="VA">Virginia</option>
								<option value="WA">Washington</option>
								<option value="WV">West Virginia</option>
								<option value="WI">Wisconsin</option>
								<option value="WY">Wyoming</option>
							</form:select>
						</div>
						<div class="col s9 input-field">
							<form:input path="zipcode" id="zip" type="text"/>
							<label for=zip>Zipcode</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="password" id="pw" type="password"/>
							<label for=pw>Password</label>
						</div>
						<div class="col s9 input-field">
							<form:input path="passwordConfirmation" id="pwc" type="password"/>
							<label for="pwc">Confirm Password</label>
						</div>
						<div class="">
							<button class="btn red " type="submit">Submit</button>
							<br />
						</div>
					</form:form>
				</div>
		</div>
	</div>
	<script>
		$("document").ready(function(){
			$(".cand").click(function(){
				$(".unchecked").hide();
				$(".candidateForm").show();
			})
			$(".constit").click(function(){
				$(".unchecked").hide();
				$(".constituentForm").show();
			})
			$(".back").click(function(){
				$(".regform").hide();
				$(".unchecked").show();
			})

		});
	
	
	
	</script>
	
</body>
</html>