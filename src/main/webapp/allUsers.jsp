<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <h3>The list of users:</h3>
    
        <sql:setDataSource var="snapshot" driver="org.apache.derby.jdbc.ClientDriver"
             url="jdbc:derby://localhost:1527/simplewebdb"
             user="simple"  password="simple"/>
        
        <sql:query dataSource="${snapshot}" var="result">
            select * from users
        </sql:query>
        
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
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.user_id}"/></td>
                    <td><c:out value="${row.first_name}"/></td>
                    <td><c:out value="${row.last_name}"/></td>
                    <td><c:out value="${row.email}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>