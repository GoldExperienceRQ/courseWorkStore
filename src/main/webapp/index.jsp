<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="styles/index.css">
    <link rel="stylesheet" href="styles/home.css">
</head>
<body>

<nav>
    <h1 class="header">Welcome To Store Manager App</h1>
    <%if (request.getSession().getAttribute("user") == null) {%>
    <a class="auth" href="${pageContext.request.contextPath}/store/login">Login</a>
    <%} else {%>
    <a class="auth" href="${pageContext.request.contextPath}/store/logout">Logout</a>
    <%}%>
</nav>

<div class="menu">
    <a class="menu-item" href="${pageContext.request.contextPath}/store/category/all">See all Categories</a>
    <br/>
    <a class="menu-item" href="${pageContext.request.contextPath}/store/allGoods">All goods in the store</a>
    <br/>
    <a class="menu-item" href="${pageContext.request.contextPath}/store/inventory">Supply/Write Off</a>
    <br/>
</div>


</body>
</html>