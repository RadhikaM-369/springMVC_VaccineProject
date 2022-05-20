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
            padding: 50px;
            background: #828b00;
            color: white;
         }
        
        .card-footer {
            padding: 50px;
            background: #828b00;
            color: white;
            position: absolute;
            width:100%;
            bottom:0;
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
	<div class="card-header"><h1>Reset your password here</h1><br>
	<div class="d-grid gap-2 d-md-flex justify-content-end">
	</div>
	</div>	
	<div class="card" style="width: 70rem; height:40rem;">
		<div class="card-body">
			<h1 class="card-title"></h1>
	<form action="reset" >
	<br> <br>
	<h1>${confirmpassword}</h1>
	<div><label><h3>Enter Email-Id</h3></label> <input type="email" name="email" class="form-control"></div><br> 
	<div><label><h3>Enter new password</h3></label> <input type="password" name="newPassword" class="form-control"></div><br>
	<div><label><h3>Enter confirm password</h3></label> <input type="password" name="confirmPassword" class="form-control"></div><br><br>
	<div><input	class="btn btn-primary btn-lg" type="submit" value="RESET PASSWORD" ></div>
	</form>
	</div>
	</div>

	<div class="card-footer"><i>created by:Radhika M. Magadum</i></div>
	
</html>