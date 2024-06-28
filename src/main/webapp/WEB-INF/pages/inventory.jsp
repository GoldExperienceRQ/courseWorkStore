<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/26/2024
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventory</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/inventory.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>

<a class="home-link" href="${pageContext.request.contextPath}/store">Back to Store</a>

<h1 class="header">Supply/Write off</h1>
<br/>

<form action="${pageContext.request.contextPath}/store/inventory" method="POST">

    <div class="item">
        <label for="good">Good</label>
        <select id="good" name="good">
            <c:forEach var="good" items="${goods}">
                <option value="${good.name}">${good.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="item">
        <label for="operation">Operation</label>
        <select id="operation" name="operation">
            <option value="supply">Supply</option>
            <option value="write-off">Write off</option>
        </select>
    </div>

    <div class="item">
        <label for="quantity">Quantity</label>
        <input type="number" id="quantity" name="quantity" min="0" placeholder="Quantity"/>
    </div>

    <button type="submit" class="change-btn">Change</button>
</form>
</body>
</html>
