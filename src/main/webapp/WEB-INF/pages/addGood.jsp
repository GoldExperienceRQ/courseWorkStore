<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/24/2024
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add good</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addGood.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
    <h1>Add a new good to ${category}</h1>

    <form action="${pageContext.request.contextPath}/store/category/goods/${category}" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" >
        <br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" >
        <br>
        <label for="producer">Producer:</label>
        <input type="text" id="producer" name="producer">
        <br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" >
        <br>
        <label for="price">Price:</label>
        <input type="number" id="price" name="price">

        <input type="hidden" id="category" name="category" value="${category}">

        <br>
        <button type="submit">Add Good</button>
    </form>

    <script src="${pageContext.request.contextPath}/scripts/goodValidation.js"></script>

</body>
</html>
