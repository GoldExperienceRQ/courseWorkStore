<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/24/2024
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/categories.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<h1>Here you can see all categories</h1>
<a href="${pageContext.request.contextPath}/store">Go home</a>
<br/>
<c:forEach items="${categories}" var="category">
    <div class="category-data">
        <p id="${category.name}">${category.name}, ${category.description}</p>
        <a href="${pageContext.request.contextPath}/store/category/update?category=${category.name}">Update</a>
        <a href="${pageContext.request.contextPath}/store/category/delete?category=${category.name}">Delete</a>
        <br/>
        <a href="${pageContext.request.contextPath}/store/category/goods/${category.name}">See goods in this category</a>
    </div>
</c:forEach>
<br/>
<a href="${pageContext.request.contextPath}/store/category/add">Add Category</a>

</body>
</html>
