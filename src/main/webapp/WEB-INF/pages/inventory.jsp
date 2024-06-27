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
<h1>Supply/Write off</h1>
<br/>
<a href="${pageContext.request.contextPath}/store">Back to Store</a>

<form action="${pageContext.request.contextPath}/store/inventory" method="POST">
    <label for="good">Good</label>
    <select id="good" name="good">
        <c:forEach var="good" items="${goods}">
            <option value="${good.name}">${good.name}</option>
        </c:forEach>
    </select>

    <label for="operation">Operation</label>
    <select id="operation" name="operation">
        <option value="supply">Supply</option>
        <option value="write-off">Write off</option>
    </select>

    <label for="quantity">Quantity</label>
    <input type="number" id="quantity" name="quantity" placeholder="Quantity"/>

    <button type="submit">Change</button>
</form>
</body>
</html>
