<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/24/2024
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<h1 class="header">Login</h1>

<form action="${pageContext.request.contextPath}/store/login" method="post">


    <div class="form-element">
        <label for="username">Login Name</label>
        <input type="text" id="username" name="username" placeholder="Username"/>
    </div>

    <div class="form-element">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Password"/>
    </div>
    <p class="error-msg">${error}</p>

    <button type="submit" id="login-btn">Login</button>
</form>
</body>
</html>
