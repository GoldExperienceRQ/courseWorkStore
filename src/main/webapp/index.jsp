<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles/index.css">
</head>
<body>
<h1 class="header">Welcome to Store Manager App</h1>
<br/>


<a href="${pageContext.request.contextPath}/store/category/all">See all Categories</a>
<br/>
<a href="${pageContext.request.contextPath}/store/allGoods">All goods in the store</a>
<br/>
<a href="${pageContext.request.contextPath}/store/inventory">Supply/Write Off</a>
<br/>

<%if(request.getSession().getAttribute("user") == null){%>
<a href="${pageContext.request.contextPath}/store/login">Login</a>
<%} else{%>
<a href="${pageContext.request.contextPath}/store/logout">Logout</a>
<%}%>

</body>
</html>