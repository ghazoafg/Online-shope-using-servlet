<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cart</title>
</head>
<body>
<h1>Cart</h1>
<table>
  <tr>
    <th>Product</th>
    <th>Quantity</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${cart}" var="product">
    <tr>
      <td>${product.id}</td>
      <td>
        <form action="UpdateCartServlet" method="post">
          <input type="hidden" name="id" value="${product.id}">
          <input type="number" name="quantity" value="${product.quantity}">
          <input type="submit" value="Update">
        </form>
      </td>
      <td>
        <form action="RemoveFromCartServlet" method="post">
          <input type="hidden" name="id" value="${product.id}">
          <input type="submit" value="Remove">
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="productList.jsp">Back to product list</a>
</body>
</html>
