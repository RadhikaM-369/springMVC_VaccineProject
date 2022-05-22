<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css "
	rel="stylesheet "
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3 "
	crossorigin="anonymous">

<style>
body {
	font-family: Arial;
	margin: 0;
	text-align: center;
	size: 100px
}

.card {
	margin: 0 auto;
	/* Added */
	float: none;
	/* Added */
	margin-bottom: 05px;
	/* Added */
}

.card-header {
	padding: 30px;
	background: #828b00;
	color: white;
}

.card-footer {
	padding: 30px;
	background: #828b00;
	color: white;
	position: absolute;
	width: 100%;
	bottom: 0;
}

.button {
	background: #828b00;
	color: white;
	align: center;
}

.Content {
	padding: 90px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<div class="card-header">
		<h1>LOGIN Information</h1>
		<br>
	</div>
	<div class="card" style="width: 70rem; height: 40rem;">
		<div class="card-body">
			<h1 class="card-title"></h1>
						
			<form action="login" method="post">
				<br>
				<h3>${regStatus}</h3>
				<h3>${mailSent}</h3>
				<h3>${CredentialStatus}</h3>
			<!-- <p class="text-danger">.text-danger</p> -->	
				<h3 class="text-danger">${blockuserStatus}</h3>
				<br>
				<br>
				<br>
				<br>

				<div>
					<label>
						<h3>Enter UserName :</h3>
					</label><input type="text" name="userName">
				</div>
				<div>
					<label>
						<h3>Enter Password :</h3>
					</label> <input type="password" name="pswd">
				</div>
				<br>
				<br>
				<br>
				<br>
				<div>
				<input class="btn btn-primary" type="submit" value="LOGIN" />
				</div>
<br>
				<br>
				<!-- 
<button type="button" class="btn btn-primary"><h3>LOGIN</h3></button>
<input type="submit" value="login" class=""><h3>LOGIN</h3>
 -->
			</form>
			<div>
				<a class="btn btn-primary" href="resetPassword">RESET
						PASSWORD</a>
			</div>
		</div>
	</div>
	<div class="card-footer">
		<i>created by:Radhika M. Magadum</i>
	</div>
</body>
</html>