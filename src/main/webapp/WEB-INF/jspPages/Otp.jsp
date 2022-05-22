<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
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
}

.button {
	background: #828b00;
	color: white;
}
.Content{
            padding: 90px;
            }
</style>
</head>
<body>

<%
    response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");
  	if(session.getAttribute("email")==null)
  		response.sendRedirect("Welcome.jsp");
%>

<div class="card-header"><h1>Vaccine Information</h1>
</div>	
	<div class="card" style="width: 70rem;height:40rem">
		<div class="card-body">
			<h3 class="card-title"> Please provide information</h3>
	<form action="otp" method="post">
		<br> <br>
		<h3>${verifiedOTPmsg}</h3>
		<h2>This Is OTP Page</h2>
		<br> <br>
		<div>
			<label> Enter OTP : </label><input type="text" name="otp">
		</div>
		<br><br>
		<div>
			<input	class="btn btn-primary btn-lg" type="submit" value="GET OTP" >
		</div>
	</form>
	</div>
	</div>
</body>
<div class="card-footer">created by:Radhika M. Magadum</div>
</html>
