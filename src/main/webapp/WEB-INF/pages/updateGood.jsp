<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/25/2024
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Good</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addGood.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<h1 class="header">Update the ${good.name}</h1>

<form action="${pageContext.request.contextPath}/store/category/goods/${good.category}" method="POST">

    <input type="hidden" name="_method" value="PUT">


    <div class="item">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${good.name}" disabled>
        <input type="hidden" name="name" value="${good.name}">
    </div>
    <div class="item">
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${good.description}">
    </div>
    <div class="item">
        <label for="producer">Producer:</label>
        <input type="text" id="producer" name="producer" value="${good.producer}">
    </div>
    <div class="item">
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="${good.quantity}">
    </div>
    <div class="item">
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="${good.price}">
    </div>

    <input type="hidden" id="category" name="category" value="${good.category}">


    <button type="submit" class="btn">Update Good</button>
</form>
<script src="${pageContext.request.contextPath}/scripts/goodValidation.js"></script>

</body>
</html>
