<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Complete</title>
    </head>
    <body>
        <h2>Congratulations!</h2>
        You have been registered with the next data:
        <table border="1">
            <tbody>
                <tr>
                    <td>First Name</td>
                    <td><%= request.getAttribute("firstName") %></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><%= request.getAttribute("lastName") %></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%= request.getAttribute("email") %></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>