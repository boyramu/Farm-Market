<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64" %>
<%@ page import="com.ecommerce.farmmarket.model.Animal" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Animal Details</title>
    <link rel="stylesheet" href="static/css/AnimalDetailscss.css">
</head>
<body>
<% 
  int cid=(Integer)request.getAttribute("customerid");
%>
<!-- Navbar -->
<div class="navbar">
    <form action="orders" method="post" class="navbar-item">
        <input type="number" name="id" hidden value="123">
        <button type="submit">Orders</button>
    </form>

    <form action="cart" method="post" class="navbar-item">
        <button type="submit">Cart</button>
    </form>

    <div class="navbar-item user">
        <a href="userProfile">User</a>
    </div>
</div>


<div class="animal-details">
    <%
        Animal animal = (Animal) request.getAttribute("animal");
        if (animal != null) {
    %>
            <h2><%= animal.getName() %></h2>
            <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(animal.getImage()) %>" alt="<%= animal.getName() %>" class="animal-image">
            
            <p><strong>Breed:</strong> <%= animal.getBreed() %></p>
            <p><strong>Age:</strong> <%= animal.getAge() %> years</p>
            <p><strong>Price:</strong> <%= animal.getPrice() %></p>
            <p><strong>Color:</strong> <%= animal.getColor() %></p>
            <p><strong>Description:</strong> <%= animal.getDescription() %></p>
            <p><strong>Status:</strong> <%= animal.getStatus() %></p>
            <c:if test="${animal.getStatus() == 'GIVING_MILK'}">
                <p><strong>Milk Yield:</strong> <%= animal.getMilkYield() %> liters/day</p>
            </c:if>
            <!-- Order and Add to Cart Buttons -->
    <div class="button-container">
        <form action="order" method="post">
            <input type="hidden" name="animalId" value="<%= animal.getId() %>">
            <input type="hidden" name="customerId" value="<%= cid %>">
            <button type="submit" class="btn">Order</button>
        </form>

        <form action="cart" method="post">
            <input type="hidden" name="animalId" value="<%= animal.getId() %>">
            <input type="hidden" name="customerId" value="<%= cid %>">
            <button type="submit" class="btn btn-cart">Add to Cart</button>
        </form>
    </div>
    <%
        } else {
    %>
        <p>Animal details not available.</p>
    <%
        }
    %>
</div>

</body>
</html>
