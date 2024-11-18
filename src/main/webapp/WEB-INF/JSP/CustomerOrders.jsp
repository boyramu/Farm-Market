<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<%@ page import="com.ecommerce.farmmarket.model.Animal" %>
<%@ page import="com.ecommerce.farmmarket.model.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ordered Animals</title>
    <link rel="stylesheet" href="static/css/AnimalHome.css">
</head>
<body>
<%
  Customer customer= (Customer) request.getAttribute("customer");
%>
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
                    <c:if test="${animal.getStatus() == 'GIVING_MILK'}">
                        <p><strong>Milk Yield:</strong> <%= animal.getMilkYield() %> liters/day</p>
                    </c:if>
                </div>
    <%
            }
        } else {
    %>
        <p>no orders till now.....</p>
    <%
        }
    %>
</div>

</body>
</html>
