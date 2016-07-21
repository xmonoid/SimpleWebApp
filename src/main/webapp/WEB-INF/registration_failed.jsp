<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <h2>Registration failed!</h2>
        The reason: <%= request.getAttribute("errorMessage").replaceAll("\n", "<br/>") %>
    </body>
</html>