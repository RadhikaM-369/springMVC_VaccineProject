<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  font-family: Arial;
  margin: 0;
   text-align: center;
}

.header {
  padding: 30px;
  background: #E389B9;
  color: white;
 }

.footer{
  padding: 100px;
  background: #E389B9;
  color: white;
  }
 --Page Content 
.content {padding:20px;}
</style>

<div class="header">
  <h1>WELCOME</h1>
  <p>Please provide the Information </p>
</div>

<body>
<form action="welcome" method="post">
<br><br>
<div><label> Enter Email : </label> <input type="text" name="email"></div>
<br><br>
<div><input type="submit" value="Get OTP" ></div>
<br><br>
</form>
</body>
<div class="footer">  
  <h6>page created by:R M Magadum</h6>
</div>
</html>