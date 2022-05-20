<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	position: absolute;
	width:100%;
	bottom:0;
}

.button {
	background: #828b00;
	color: white;	
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
<%
    response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    session.invalidate();
%>
</head>

<body>
	<div class="card-header"><h1>Vaccine Information</h1> </div>
	<div class="d-grid gap-2 d-md-flex justify-content-end">
	<a href="<c:url value='/logout' />" class="btn btn-primary btn-lg" role="button" ><h3>LOG OUT</h3></a>
	</div>
	<div class="card" style="width:70rem;height:40rem;">
	<div class="card-body">
	<h3 class="card-title"></h3>
	
	<form action="vaccineHomepage" method="post">
	<div><br><h3> Register for Vaccine </h3></div>
	<h3>${displayAllStatus}</h3> 
	<div class="d-grid gap-2 d-md-flex justify-content-end">
		<input type="submit" value="ADD MEMBER" class="btn btn-primary btn-lg">  
	</div>
	<h3>${countValue}</h3>
	</form>
	
	<div><h3>DETAILS OF MEMBERS PRESENT IN DATABASE ..</h3>	</div>	
	<table border="1">
	<thead>
  <tr>
  <th>ID</th>
    <th>MEMBER_NAME</th>
    <th>YOB</th>
    <th>GENDER</th>
    <th>ID_PROOF</th>
    <th>ID_NUMBER</th>
    <th>VACCINE_TYPE</th>
    <th>DOSE</th>
  </tr>
  </thead>
  <tbody> 
  <c:forEach items="${ListOfAllMembers}" var="member"> 
 <tr> 
 	<td>${member.id}</td>
    <td>${member.name}</td>
    <td>${member.yob}</td>
    <td>${member.gender}</td>
    <td>${member.idProof}</td>
    <td>${member.idNumber}</td>
    <td>${member.vaccineType}</td>
    <td>${member.dose}</td>
  </tr>
  </c:forEach>
   </tbody>
</table>
<!-- <form action="getAllAddMembers" method="post"></form>
<table>
<tbody> 
  <c:forEach items="${ListOfAllMembers}" var="member"> 
 <tr> 
 	<td>${member.id}</td>
    <td>${member.name}</td>
    <td>${member.yob}</td>
    <td>${member.gender}</td>
    <td>${member.idProof}</td>
    <td>${member.idNumber}</td>
    <td>${member.vaccineType}</td>
    <td>${member.dose}</td>
  </tr>
  </c:forEach>
   </tbody>
   </table>
 -->
	</div>
	</div>
</body>
<div class="card-footer">created by:Radhika M. Magadum</div>
</html>