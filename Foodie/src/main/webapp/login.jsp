<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styleslogin.css">
    <title>Login</title>
</head>
<body class="box">
    <div class="login-container">
        <h1>Login</h1>
        <form action="login" method="post">
        <!-- it will redirect to the given jsp file after receiving the correct information -->
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required placeholder="Enter your name"><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required placeholder="Enter your password">
            
            <br>
            <br>
            <input type="submit" value="Login"><br>
        </form>
    </div>
</body>
</html>
    