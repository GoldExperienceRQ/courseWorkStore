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
<a href="${pageContext.request.contextPath}/store">Go home</a>
<h1>All goods</h1>
<br/>

    <c:forEach var="good" items="${goods}">
        <div>
            <p id="${good.name}">Name: ${good.name}, Category: ${good.category}, Price: ${good.price}, Producer: ${good.producer},
                Quantity: ${good.quantity}, Description: ${good.description}
            </p>
            <p>Total worth of ${good.name} is ${good.price*good.quantity}</p>
        </div>
    </c:forEach>

</body>
</html>
