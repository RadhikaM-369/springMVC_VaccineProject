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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<style>
body {
  font-family: Arial;
  margin: 0;
   text-align: center;
}

.header {
  padding: 30px;
  background: #00008B;
  color: white;
 }

.footer{
  padding: 100px;
  background: #00008B;
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
<br><br><h1>${msg}</h1>
<h2>${validOTPmsg}</h2>
<h2>${verifiedOTPmsg1}</h2>
<h2>${verifiedOTPmsg}</h2>

<div><label> Enter Email : </label> <input type="text" name="email"></div>
<br><br>
<div><input type="submit" class="btn btn-info" value="GET OTP"></div>
<br><br>
</form>
</body>
<div class="footer">  
  <h6><i>created by:Radhika M. Magadum</i> </h6>
</div>
</html>