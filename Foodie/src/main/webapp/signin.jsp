<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link rel="stylesheet" href="stylesignin.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h1>Sign In</h1>
            <form action="/login" method="POST">
                <div class="input-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="input-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="sign-in-btn">Sign In</button>
            </form>
            <p class="signup-link">Don't have an account? <a href="/signup">Sign Up</a></p>
        </div>
    </div>
</body>
</html>
    