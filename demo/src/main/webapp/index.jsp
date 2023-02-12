<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <style>
        .background {
            background-image: url("shop1.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center center;
            height: 100vh;
        }
    </style>
    <title>JSP - Hello World</title>
</head>
<body>
<div class="background">


<h1 style="color: yellow"><%= "Welcome to ghazanfar shoping" %>
</h1>
<br/>
<a href="login.jsp">Click to Login</a>
</div>
</body>
</html>