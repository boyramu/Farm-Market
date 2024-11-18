<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<%@ page import="com.ecommerce.farmmarket.model.Animal" %>
<%@ page import="com.ecommerce.farmmarket.model.Customer" %>
<%@ page import="com.ecommerce.farmmarket.model.Orders" %>
<%@ page import="com.ecommerce.farmmarket.model.Cart" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>farm market</title>
    <link rel="stylesheet" href="static/css/AnimalHome.css">
</head>
<body>
<%
  Customer customer= (Customer) request.getAttribute("customer");
  List<Orders> orders=(List<Orders>) request.getAttribute("orders");
  List<Cart> cart=(List<Cart>) request.getAttribute("cartItems");
  
%>
<%
    String message = (String) session.getAttribute("res");
    if (message != null) {
%>
    <div class="notification">
        <p><%= message %></p>
    </div>
<%
        // Remove the message after displaying it once
        session.removeAttribute("res");
    }
%>
<div class="navbar">
    <form action="getorders" method="post" class="navbar-item">
        <input type="number" name="cid" hidden value="<%= customer.getCid() %>">
        <button type="submit" class="order-button">
    <span class="order-count"><%= orders != null ? orders.size() : 0 %></span> Orders
        </button>
    </form>

    <form action="getCartItems" method="post" class="navbar-item">
        <input type="number" name="cid" hidden value="<%= customer.getCid() %>">
        <button type="submit" class="order-button">
    <span class="order-count"><%= cart != null ? cart.size() : 0 %></span> Cart
        </button>
    </form>

    <div class="navbar-item user">
        <a href="userProfile">profile</a>
        <!-- Dropdown with customer info -->
        <div class="dropdown-content">
            <div class="customer-info">
                <p><strong>Name:</strong> <%= customer.getFullName() %></p>
                <p><strong>Email:</strong> <%= customer.getEmail() %></p>
                <p><strong>Phone:</strong> <%= customer.getPhoneNumber() %></p>
                <p><strong>Address:</strong> <%= customer.getAddress() %></p>
                <p><strong>total orders:</strong> <%= orders != null ? orders.size() : 0 %> </p>
            </div>
        </div>
    </div>
    <form action="logout" method="post" class="navbar-item">
        <button type="submit" class="order-button">
    Signout
        </button>
    </form>
</div>

<h1>WELCOME TO FARM MARKET</h1>

<div class="animal-container">
    <%
        List<Animal> animals = (List<Animal>) request.getAttribute("animals");
       
        if (animals != null && !animals.isEmpty()) {
            for (Animal animal : animals) {
    %>
                <div class="animal-item">
                    <h3><%= animal.getName() %></h3>

                    <!-- Animal Image with link to details page -->
                    <a href="animalDetails?id=<%= animal.getId() %>&customerId=<%= customer.getCid() %>">
                        <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(animal.getImage()) %>" alt="<%= animal.getName() %>" class="animal-image">
                    </a>
                    
                    <p><strong>Breed:</strong> <%= animal.getBreed() %></p>
                    <p><strong>Price:</strong> <%= animal.getPrice() %></p>
                    <c:if test="${animal.getStatus() == 'GIVING_MILK'}&&${animal.getMilkYield()>0.0}">
                        
                          <p><strong>Milk Yield:</strong> <%= animal.getMilkYield() %> liters/day</p>  
                    </c:if>
                </div>
    <%
            }
        } else {
    %>
        <p>No animals available.</p>
    <%
        }
    %>
</div>

</body>
</html>
