<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;

            height: 100vh;
        }

        h2 {
            text-align: center;
        }

        p {
            text-align: center;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 10px;
            text-decoration: none;
            color: #4caf50;
        }
    </style>
</head>
<body>
    <h2>Welcome</h2>
    <c:if test="${empty sessionScope.name}">
        <p>Please login first.</p> <br>
        <a href="login.jsp">Login</a>  <br>
        <a href="register.jsp">Register</a> <br>
    </c:if>
    <c:if test="${not empty sessionScope.name}">
        <p>Hello, ${sessionScope.name}!</p><br>
        <a href="LogoutServlet">Logout</a><br>
    </c:if>
</body>
</html>
