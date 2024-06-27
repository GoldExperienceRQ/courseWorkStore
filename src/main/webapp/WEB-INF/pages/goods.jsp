<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/24/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/goods.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/store/category/all">Back to categories</a>
<h1>Goods in Category ${category}</h1>
<br/>
<form action="${pageContext.request.contextPath}/store/category/goods/${category}/lookup" method="GET">
    <label for="search">Search</label>
    <input type="text" id="search" name="search" placeholder="Search a good">
    <button type="submit">Search</button>
</form>

<br/>
<br>
<c:set var="categoryWorth" value="${0}" scope="page"/>
<c:forEach var="good" items="${goods}">
    <c:set var="categoryWorth" value="${categoryWorth + good.price*good.quantity}" scope="page"/>
    <p id="${good.name}">Name: ${good.name}, Category: ${good.category}, Description: ${good.description}, Producer: ${good.producer}, Quantity: ${good.quantity}, Price: ${good.price}</p>

    <a href="${pageContext.request.contextPath}/store/category/goods/${category}/update?good=${good.name}">Update</a>
    <a href="${pageContext.request.contextPath}/store/category/goods/${category}/delete?good=${good.name}">Delete</a>
</c:forEach>
<br>
<p>Total worth of this category: ${categoryWorth}</p>
<a href="${pageContext.request.contextPath}/store/category/goods/${category}/add">Add a good</a>

</body>
</html>
