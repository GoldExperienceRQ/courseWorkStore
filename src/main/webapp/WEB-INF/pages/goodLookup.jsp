<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/26/2024
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Good lookup</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/goods.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<a class="category-link"  href="${pageContext.request.contextPath}/store/category/goods/${category}">Back to category</a>

<form class="search" action="${pageContext.request.contextPath}/store/category/goods/${category}/lookup" method="GET">
    <label for="search">Search</label>
    <input type="text" id="search" name="search" placeholder="Search a good">
    <button type="submit">Search</button>
</form>
<h1 class="header">Search result by ${searchValue}</h1>
<c:forEach var="good" items="${goods}">
    <div class="item">
        <p>Name: ${good.name}</p>
        <p>Category: ${good.category}</p>
        <p>Description: ${good.description}</p>
        <p>Producer: ${good.producer}</p>
        <p>Quantity: ${good.quantity}</p>
        <p>Price: ${good.price}</p>

        <a class="btn" href="${pageContext.request.contextPath}/store/category/goods/${category}/update?good=${good.name}">Update</a>
        <a class="btn" href="${pageContext.request.contextPath}/store/category/goods/${category}/delete?good=${good.name}">Delete</a>
    </div>
</c:forEach>
</body>
</html>
