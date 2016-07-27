<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <h2>Registration failed!</h2>
        <p>The reason: <%= request.getAttribute("errorMessage").toString().replaceAll("\n", "<br/>") %></p>
        <p>Please, <a href="${pageContext.request.contextPath}/">try again</a>.</p>
    </body>
</html>