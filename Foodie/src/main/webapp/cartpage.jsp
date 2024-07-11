<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Swiggy Cart Page</title>
    <link rel="stylesheet" href="stylecart.css">
</head>
<body>
    <div class="container">
        <header>
            <img src="swiggy-logo.png" alt="Swiggy Logo" class="logo">
            <h1>Secure Checkout</h1>
        </header>
        <main>
            <div class="account-section">
                <h2>Account</h2>
                <p>To place your order now, log in to your existing account or sign up.</p>
                <input type="text" placeholder="Phone number" class="input-box">
                <button class="login-button">Login</button>
                <p>By clicking on Login, I accept the <a href="#">Terms & Conditions</a> & <a href="#">Privacy Policy</a></p>
            </div>
            <div class="order-summary">
                <h2>Pizza Hut</h2>
                <p>MG Road</p>
                <div class="order-item">
                    <p>Melts Meal for 1 with Fries - Veg</p>
                    <div class="item-quantity">
                        <button class="quantity-button">-</button>
                        <span>1</span>
                        <button class="quantity-button">+</button>
                    </div>
                    <p>₹259</p>
                </div>
                <label>
                    <input type="checkbox"> Opt in for No-contact Delivery
                </label>
                <div class="order-info">
                    <p>Review your order and address details to avoid cancellations</p>
                    <p>If you choose to cancel, you can do it within 60 seconds after placing the order. Post 60 seconds, you will be charged a 100% cancellation fee. However, in the event of an unusual delay of your order, you will not be charged a cancellation fee. This policy helps us avoid food wastage and compensate restaurants / delivery partners for their efforts.</p>
                </div>
                <div class="bill-details">
                    <p>Item Total: ₹259</p>
                    <p>Delivery Fee (2.3 kms): ₹36</p>
                    <p>Platform fee: ₹5</p>
                    <p>GST and Restaurant Charges: ₹50.60</p>
                    <h3>Total: ₹351</h3>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
    