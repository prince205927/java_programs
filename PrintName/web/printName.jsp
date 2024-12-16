<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Print Name</title>
</head>
<body>
    <h3>Names:</h3>
    <ul>
        <%
            String name = "Prince Sapkota"; 
            for (int i = 0; i < 10; i++) {
        %>
            <li><%= name %></li>
        <%
            }
        %>
    </ul>
</body>
</html>
