<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 6/25/2024
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALl goods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/allGoods.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<a class="home-link" href="${pageContext.request.contextPath}/store">Go home</a>
<h1 class="header">All goods</h1>
<br/>

<c:set value="${1}" var="counter" scope="page"/>
<c:forEach var="good" items="${goods}">
    <div class="item">
        <p><b>Item ${counter}</b></p>
        <p>Name: ${good.name}</p>
        <p>Category: ${good.category}</p>
        <p>Price: ${good.price}</p>
        <p>Producer: ${good.producer}</p>
        <p>Quantity: ${good.quantity}</p>
        <p>Description: ${good.description}</p>
        <p>Total worth of ${good.name} is ${good.price*good.quantity}</p>
    </div>
    <c:set var="counter" value="${counter + 1}" scope="page"/>
</c:forEach>

</body>
</html>
