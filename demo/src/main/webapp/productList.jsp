<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <style>
    .background {
      background-image: url("shop2.jpg");
      background-size: cover;
      background-repeat: no-repeat;
      background-position: center center;
      height: 100vh;
    }
  </style>
  <meta charset="UTF-8">
  <title>Product List</title>

</head>
<body>
<div class="background">

<h1>Product List</h1>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Action</th>
  </tr>
  <c:forEach var="product" items="${productList}">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.quantity}</td>
      <td>${product.price}</td>
      <td>
        <a href="AddToCartServlet?id=${product.id}">Add to Cart</a>
      </td>
    </tr>
  </c:forEach>
</table>
<br>
<a href="ViewCartServlet">View Cart</a>
<br>
<a href="Cart.jsp">Update Cart</a>
<br>
<a href="LogoutServlet">Logout</a>
</div>
</body>
</html>