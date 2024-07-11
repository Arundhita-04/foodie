<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.List,com.foodie.model.Restaurant,com.foodie.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant List</title>
<link rel="stylesheet" href="restaurantstyle.css">
</head>
<body>
	<header>
    <nav>
        <div class="logo">Foodie</div>
    </nav>
    </header>
    
    <section class="resturant-list">
    <h2>&nbsp;&nbsp;&nbsp;Featured Restaurants</h2>
    <!-- here i want to display all the restaurants we have using the the flex box concept display 6 restaurants at a time --> 
    <!-- restaurants detail we are getting with the help of session -->
   	 <div class="restaurants">
        <% 
            // Assuming you have a list of restaurants in the session
            List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurantList");
            if (restaurants != null) {
                for (Restaurant restaurant : restaurants) {
        %>
            <div class="restaurant">
                <img src="<%= restaurant.getImgPath() %>" alt="<%= restaurant.getName() %>">
                <h3><%= restaurant.getName() %></h3>
                <p><%= restaurant.getCusineType() %>
                -
                <%= restaurant.getDeliveryTime() %>
                mins
                
                </p>
                <!-- getting the restaurantId from the url with the help of the restaurant object and giving it to the menu -->
                <a href = "menu?restaurantId=<%=restaurant.getRestaurantId()%>"> View Menu</a>
            </div>
            
        <% 
                
                }
            } else {
        %>
            <p>No restaurants available</p>
        <% 
            } 
        %>
    
    
    %>
    
    
    </section>
    
</body>
</html>