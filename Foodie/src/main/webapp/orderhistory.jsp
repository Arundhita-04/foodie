<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History - Swiggy</title>
    <link rel="stylesheet" href="styleorderhis.css">
</head>
<body>
    <div class="container">
        <h1>Order History</h1>
        <div class="order">
            <div class="order-header">
                <span class="order-date">12th June 2024</span>
                <span class="order-status delivered">Delivered</span>
            </div>
            <div class="order-details">
                <h2>Restaurant Name</h2>
                <p>Items: 2 x Pizza, 1 x Burger</p>
                <p>Total: ₹500</p>
                <button class="reorder-btn">Reorder</button>
            </div>
        </div>
        <div class="order">
            <div class="order-header">
                <span class="order-date">10th June 2024</span>
                <span class="order-status cancelled">Cancelled</span>
            </div>
            <div class="order-details">
                <h2>Another Restaurant</h2>
                <p>Items: 1 x Sushi</p>
                <p>Total: ₹300</p>
                <button class="reorder-btn">Reorder</button>
            </div>
        </div>
    </div>
</body>
</html>
    