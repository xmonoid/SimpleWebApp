<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <form name="userdata" action="${pageContext.request.contextPath}/rhs" method="post">
            <label for="firstName" >Firstname:</label>
            <input type="text" name="firstName" id="firstName" size="20" />
            <br/>
            <label for="firstName" >Lastname:</label>
            <input type="text" name="lastName" id="lastName" size="20" />
            <br/>
            <label for="firstName" >Email:</label>
            <input type="text" name="email" id="email" size="20" />
            <br/>
            <input type="submit" name="submit" value="Submit">
        </form>
    </body>
</html>