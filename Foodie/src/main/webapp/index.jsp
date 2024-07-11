<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodie.model.User" %>
    <%@ page import="java.util.List" %>
<%@ page import="com.foodie.model.Restaurant" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Delivery App</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
   <header>
    <nav>
        <div class="logo">Foodie</div>
        <% 
            	
                // Check if the loggedIn object is present in the session
                User user = (User) session.getAttribute("userDao");
                if (user != null) {
            %>
            
            	<span class="welcome" style="color: white;">Welcome, <%= user.getUsername() %>!</span>
            	
        <ul>
            <li><a href="home.jsp">Home</a></li>
            
            <li><a href="#">About Us</a></li>
            
            
                <li><a href="viewChart.jsp">View Chart</a></li>
                <li><a href="orderHistory.jsp">Order History</a></li>
                <li><a href="profile.jsp">Profile</a></li>
            <% 
                } else { 
            %>
                <li><a href="login.jsp" class="login-btn">Login</a></li>
                <li><a href="register.jsp" class="register_btn">Register</a></li>
            <% 
                } 
            %>
        </ul>
    </nav>
</header>

    <section class="hero">
        <div class="hero-content">
            <h1>Order food online from 1000+ restaurants!</h1>
            <p>Food delivery service that's easy & convenient!</p>
            <div class="search-box">
                <select name="city" id="city">
                    <option value="" disabled selected>City</option>
                    <!-- Add more options as needed -->
                </select>
                <select name="district" id="district">
                    <option value="" disabled selected>District / Area</option>
                    <!-- Add more options as needed -->
                </select>
               	<form action="restaurant" method="get" style="display: inline;">
    <button type="submit" style="padding: 10px 20px; background-color: #FFA500; color: white; border: none; cursor: pointer;">
        SHOW RESTAURANTS
    </button>
</form>

                <!--<a href ="#/restaurant" class="show-restaurants">Show Restaurants</a>-->
            </div>
        </div>
    </section>
    <section class="featured-dishes">
        <h2>Featured Dishes</h2>
        <div class="dishes">
            <div class="dish" class="a">
                <img src="images/pizza.jfif" alt="Pizza">
                <h3>Pizza</h3>
                <p>Delicious cheese pizza with fresh ingredients.</p>
            </div>
            <div class="dish" class="b">
                <img src="images/Burger (1).jpeg" alt="Burger">
                <h3>Burger</h3>
                <p>Juicy chicken burger with crispy fries.</p>
            </div>
            <div class="dish" class="c">
                <img src="images/sushi.jpeg" alt="Sushi">
                <h3>Sushi</h3>
                <p>Fresh sushi rolls with various fillings.</p>
            </div>
        </div>
    </section>
    <section class="how-it-works">
        <h2>How it works</h2>
        <p>Get your favourite food in 4 simple steps</p>
        <div class="steps">
            <div class="step">
                <img src="images/Step1.jpeg" alt="Search">
                <h3>Search</h3>
                <p>Find all restaurants available near you</p>
            </div>
            <div class="step">
                <img src="images/Step2.jpeg" alt="Choose">
                <h3>Choose</h3>
                <p>Browse hundreds of menus to find the food you like</p>
            </div>
            <div class="step">
                <img src="images/Step3.jpeg" alt="Pay">
                <h3>Pay</h3>
                <p>It's quick, secure and easy</p>
            </div>
            <div class="step">
                <img src="images/Step4.jpeg" alt="Enjoy">
                <h3>Enjoy</h3>
                <p>Food is prepared & delivered to your door</p>
            </div>
        </div>
    </section>
    
    
    
    <section class="testimonials">
        <h2>What Our Customers Say</h2>
        <div class="testimonial">
            <p>"Foodie has the best delivery service! The food is always fresh and hot. Highly recommend!"</p>
            <h4>- Jane Doe</h4>
        </div>
        <div class="testimonial">
            <p>"Great variety of dishes and excellent customer service. I'm a regular customer now!"</p>
            <h4>- John Smith</h4>
        </div>
    </section>
    <footer>
        <div class="footer-content">
            <p>&copy; 2024 Tap Foods. All Rights Reserved.</p>
            <ul>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
    </footer>
    <script src="script.js"></script>
</body>
</html>
    