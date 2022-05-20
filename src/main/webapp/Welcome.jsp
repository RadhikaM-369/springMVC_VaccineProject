<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3 " 
	crossorigin="anonymous">

    <style>
        body {
            font-family: Arial;
            margin: 0;
            text-align: center;
            size : 100px
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
            padding: 60px;
            background: #828b00;
            color: white;
           
        }
        .button{
         background: #828b00;
            color: white;
            }
            
        .Content{
            padding: 100px;
            }
    </style>
</head>
<body>
	<div class="card-header"><h1>Vaccine Information</h1><br>
	<div class="d-grid gap-2 d-md-flex justify-content-end">
	<a class="btn btn-primary" href="getLoginPage"><h3>LOGIN</h3></a>
	<a class="btn btn-primary" href="register" class="button" role="button" ><h3>Register</h3></a></div>
	</div>	
	<div class="card" style="width: 70rem; height:35rem;">
		<div class="card-body">
			<h1 class="card-title">WELCOME</h1>
			<form action="welcome" >
				<br> <br>
				<h1>${msg}</h1>
				<h2>${validOTPmsg}</h2>
				<h2>${verifiedOTPmsg1}</h2>
				<h2>${verifiedOTPmsg}</h2>

				<label><h3>Enter Email-Id</h3></label> <input type="email" name="email" class="form-control"><br> <br>
				
				 <input	class="btn btn-primary btn-lg" type="submit" value="GET OTP" >
			</form>
		</div>
	</div>

	<div class="card-footer"><i>created by:Radhika M. Magadum</i></div>
	
</html>