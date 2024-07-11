<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link rel="stylesheet" href="stylecheckout.css">
</head>
<body>
    <div class="checkout-container">
        <h1>Checkout</h1>
        <div class="order-summary">
            <h2>Order Summary</h2>
            <ul>
                <li>
                    <span>Pizza</span>
                    <span>$10.00</span>
                </li>
                <li>
                    <span>Burger</span>
                    <span>$5.00</span>
                </li>
                <li>
                    <span>Delivery Fee</span>
                    <span>$2.00</span>
                </li>
            </ul>
            <div class="total">
                <span>Total</span>
                <span>$17.00</span>
            </div>
        </div>
        <form class="payment-form">
            <h2>Payment Details</h2>
            <label for="card-number">Card Number</label>
            <input type="text" id="card-number" name="card-number" placeholder="1234 5678 9012 3456" required>

            <label for="expiry-date">Expiry Date</label>
            <input type="text" id="expiry-date" name="expiry-date" placeholder="MM/YY" required>

            <label for="cvv">CVV</label>
            <input type="text" id="cvv" name="cvv" placeholder="123" required>

            <button type="submit">Place Order</button>
        </form>
    </div>
</body>
</html>
    