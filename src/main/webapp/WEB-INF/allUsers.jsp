<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="ru.nlmk_it.edu.entities.User"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <h3>The list of users:</h3>
        
        <table border="1">
            <thead>
                <tr>
                   <th>User ID</th>
                   <th>First Name</th>
                   <th>Last Name</th>
                   <th>Email</th>
                </tr>
            </thead>
            <tbody>
            
                <%
                    List<User> userList = (List<User>) request.getAttribute("userList");
                    for (User user: userList) {
                %>
                <tr>
                    <td><%= user.getUserId() %></td>
                    <td><%= user.getFirstName() %></td>
                    <td><%= user.getLastName() %></td>
                    <td><%= user.getEmail() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>