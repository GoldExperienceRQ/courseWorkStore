<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/24/2024
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addCategory.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<h1>Add new category</h1>

<form action="${pageContext.request.contextPath}/store/category/all" method="POST">
    <label for="name">Category Name</label>
    <input type="text" id="name" name="name" placeholder="Category Name" />

    <label for="description">Category Description</label>
    <input type="text" id="description" name="description" placeholder="Category Description"/>

    <button type="submit" id="add-category-button">Add Category</button>
</form>

<script src="${pageContext.request.contextPath}/scripts/categoryValidation.js"></script>
</body>
</html>
