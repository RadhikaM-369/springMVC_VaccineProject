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

<%
    response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");
  	if(session.getAttribute("email")==null){
  	if(session.getAttribute("userName")==null){  	
  		response.sendRedirect("Welcome.jsp");}
  	}  	
%>

	<div class="card-header"><h1>Vaccine Information</h1></div>	
	<div class="d-grid gap-2 d-md-flex justify-content-end">
	<a href="<c:url value='/logout'/>" class="btn btn-primary btn-lg" role="button" ><h3>LOG OUT</h3></a>
	</div>
	
	<div class="card" style="width:70rem; height:40rem;">
	<div class="card-body">
	<h3 class="card-title">Register</h3>
	<h3>${msg}</h3>
	<form action="addMember" method="post">
	
	<div>
	<br>
	<h2>Your PHOTO ID will be verified at the time of your vaccination appointment..!</h2>
	</div>
	<table> 
  <tr>
    <td><label>Name : </label></td> <td><input type="text" name="name"></td> </tr>
  <tr><td><label>Year of Birth : </label></td><td><input type="text" name="yob"></td> </tr>
  <tr><td><label>Gender : </label></td>
  	  <td><input type="radio" id="gender" name="gender" value="FEMALE">
		  <label for="Female">Female</label><br>
		  <input type="radio" id="gender" name="gender" value="MALE">
		  <label for="Male">Male</label><br>
 		  <input type="radio" id="gender" name="gender" value="OTHER">
		  <label for="Other">Other</label></td></tr>
  <tr><td><label>Photo ID Proof</label></td>
  	  <td><select name="idProof" id="idProof">
  		<option selected>SELECT</option>
  		<option value="AdharCard">AdharCard</option>
  		<option value="voterCard">VoterCard</option>
 		<option value="PAN Card">PAN Card</option>
 		<option value="Driving License">Driving License</option>
 		<option value="Passport">Passport</option>
		</select></td></tr>
  <tr><td><label>PhotoId Proof number :</label></td>
  	  <td><input type="text" name="idNumber"></td></tr>
  <tr><td><label>Vaccine Type :</label> </td>
  	  <td><select name="vaccineType" id="vaccineType">
	  <option value="">-SELECT-</option>
	  <option value="covishield">Covishield</option>
	  <option value="covaxin">Covaxin</option>
	  <option value="sputnik">Sputnik</option>
	  </select></td></tr>
  <tr><td><label>Dose : </label></td>
  	  <td><select name="dose" id="dose">
	<option value="">-SELECT-</option>
	<option value="dose1">Dose 1</option>
	<option value="dose2">Dose 2</option>
	</select></td>
  </tr>
 </table>
  <div class="d-flex justify-content-center">
  <input class="btn btn-primary btn-lg" type="submit" value="ADD MEMBER" > 
  </div>
	</form>
	</div>
	</div>
	<div class="card-footer">created by:Radhika M. Magadum</div>
</body>
</html>
