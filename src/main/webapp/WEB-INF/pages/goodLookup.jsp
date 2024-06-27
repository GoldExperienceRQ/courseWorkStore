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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/goodLookup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/store/category/goods/${category}">Back to category</a>
<br/>
<form action="${pageContext.request.contextPath}/store/category/goods/${category}/lookup" method="GET">
    <label for="search">Search</label>
    <input type="text" id="search" name="search" placeholder="Search a good">
    <button type="submit">Search</button>
</form>

<h1>Search result by ${searchValue}</h1>
<br/>
<c:forEach var="good" items="${goods}">
    <p id="${good.name}">Name: ${good.name}, Category: ${good.category}, Description: ${good.description},
        Producer: ${good.producer}, Quantity: ${good.quantity}, Price: ${good.price}</p>

    <a href="${pageContext.request.contextPath}/store/category/goods/${category}/update?good=${good.name}">Update</a>
    <a href="${pageContext.request.contextPath}/store/category/goods/${category}/delete?good=${good.name}">Delete</a>
</c:forEach>
</body>
</html>
