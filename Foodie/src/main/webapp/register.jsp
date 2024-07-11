<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>

<h1>User registeration form</h1>
<form action = "register" method = "POST">
<!-- Here we are using post method and in our registerServlet we used the service method thats why its not giving 
any error if we use doGet or dopost then we have to override it -->
<label>UserName: </label><br>
<input type= "text" name="username"><br>
<label>Password: </label><br>
<input type= "password" name = "password"><br>
<label>Re-type Password: </label><br>
<input type="password" name = "cpassword"><br>
<label>Email: </label><br>
<input type = "text" name = "email"><br>
<label>Address: </label><br>
<input type = "text" name = "address"><br> 
<label>Role: </label><br>
<input type = "text" name = "role"><br>
<input type= "submit">
</form>
</body>
</html>

