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
            width:100%;
            bottom:0;
}

.button {
	background: #828b00;
	color: white;
	align: center;
}
.Content{
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
<div class="card-header"><h1>Vaccine Information</h1>
<a class="btn btn-primary btn-lg" href="getLoginPage">LOGIN</a></div>	
<h3>${regStatus}</h3>
<h1>--REGISTRATION INFORMATION---</h1>
<form action="registerPage" method="post">
<table> 
  <tr><td><label>User Name: </label></td> <td><input type="text" name="userName"></td> </tr>
  <tr><td><label>PassWord : </label></td> <td><input type="password" name="pswd"></td> </tr>
  <tr><td><label>Email ID : </label></td> <td> <input type="email" name="emailId"></td> </tr>
  <tr><td> <label>Date Of Birth : </label></td><td><input type="text" name="userDob"></td> </tr>
 <tr><td><label>Gender : </label></td> <td><input type="radio" id="genderR" name="genderR" value="FEMALE">
		 								   <label for="Female">Female</label><br>
		 								   <input type="radio" id="genderR" name="genderR" value="MALE">
		 								   <label for="Male">Male</label><br>
 		  								   <input type="radio" id="genderR" name="genderR" value="OTHER">
		 								   <label for="Other">Other</label></td></tr>
<tr><td><label>Mobile No. : </label></td> <td> <input type="text" name="mobileNo"></td> </tr>
</table>
 <input	class="btn btn-primary btn-lg" type="submit" value="REGISTER" >
</form>
<div class="card-footer"><i>created by:Radhika M. Magadum</i></div>
</body>
</html>