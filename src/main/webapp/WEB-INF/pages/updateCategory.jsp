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
    <title>Update Category</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addCategory.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<h1 class="header">Update category ${name}</h1>

<form action="${pageContext.request.contextPath}/store/category/${category.name}" method="POST">
    <input type="hidden" name="_method" value="PUT"/>
    <div class="item">
        <label for="name">Category Name</label>
        <input type="text" id="name" name="name" value="${category.name}" placeholder="Category Name" disabled/>
    </div>
    <input type="hidden" name="name" value="${category.name}"/>
    <div class="item">
        <label for="description">Category Description</label>
        <input type="text" id="description" name="description" value="${category.description}"
               placeholder="Category Description"/>
    </div>
    <button type="submit" class="btn">Update Category</button>
</form>
<script src="${pageContext.request.contextPath}/scripts/categoryValidation.js"></script>

</body>
</html>
