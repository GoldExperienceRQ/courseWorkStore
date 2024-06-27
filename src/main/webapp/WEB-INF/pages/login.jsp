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
<h1>Login</h1>

<form action="${pageContext.request.contextPath}/store/login" method="post">

    <p>${error}</p>

    <label for="username">Login Name</label>
    <input type="text" id="username" name="username" placeholder="Username" />

    <label for="password">Password</label>
    <input type="password" id="password" name="password" placeholder="Password"/>
    <button type="submit" id="login-button">Login</button>
</form>
</body>
</html>
