<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List,com.foodie.model.Menu,com.foodie.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foodie Menu</title>
    <link rel="stylesheet" href="stylemenu.css">
</head>
<body class="menu-body">
<header class="menu-header">
    <div class="logo"></div>
    <div class="location-search">
        <a class=""></a>
    </div>
</header>
<section class="menu-list">
    <h2>&nbsp;&nbsp;&nbsp;Featured Menu</h2>
    <div class="menu">
        <% 
            // Assuming you have a list of restaurants in the session
            List<Menu> menu = (List<Menu>) request.getAttribute("menuList");
            if (menu != null) {
                for (Menu m : menu) {
        %>
            <div class="restaurant">
                <img src="<%= m.getImgPath() %>" alt="<%= m.getItemName() %>">
                <h3><%= m.getItemName() %></h3>
                <p><%= m.getDescription() %> - 
                <br>
                <%= m.getPrice() %> Rs</p>
                <button class="add-to-cart" onclick="addToCart('<%= m.getMenuId() %>')">Add to cart</button>
            </div>
        <% 
                }
            } else {
        %>
            <p>No restaurants available</p>
        <% 
            } 
        %>
    </div>
</section>
</body>
</html>
