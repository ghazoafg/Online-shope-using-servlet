<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<style>
  .background {
    background-image: url("login.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center center;
    height: 100vh;
  }
</style>
<body>
<div class="background">
<h1>Login</h1>
<form action="LoginServlet" method="post">
  <div>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username">
  </div>
  <div>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
  </div>
  <div>
    <input type="submit" value="Login">
  </div>
</form>
</div>
</body>
</html>
