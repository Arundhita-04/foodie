<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="styleoc.css">
</head>
<body>
    <div class="confirmation-container">
        <div class="confirmation-header">
            <img src="images/Step1.jpeg" alt="Swiggy Logo" class="logo">
            <h1>Order Confirmed!</h1>
        </div>
        <div class="order-details">
            <h2>Order Summary</h2>
            <p>Order Number: <strong>#12345</strong></p>
            <p>Estimated Delivery Time: <strong>30 minutes</strong></p>
            <p>Delivery Address: <strong>123 Main Street, City</strong></p>
        </div>
        <div class="order-items">
            <h2>Your Items</h2>
            <ul>
                <li>1 x Burger</li>
                <li>2 x Pizza</li>
                <li>1 x Coke</li>
            </ul>
        </div>
        <div class="order-footer">
            <button class="track-order-btn">Track Order</button>
            <button class="order-again-btn">Order Again</button>
        </div>
    </div>
</body>
</html>
    