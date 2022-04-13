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


</head><style>

body {
  font-family: Arial;
  margin: 0;
   text-align: center;
}

.header {
  padding: 100px;
  background: #00008B;
  color: white;
 }
.footer{
  padding: 100px;
  background: #00008B;
  color: white;
  }

.content {padding:20px;}
</style>

<div class="header">
</div>
<body>

<form action="vaccineHomepage" method="post">

<h3>${verifiedOTPmsg}</h3>

</form>
</body>

<div class="footer">
</div>
</html>