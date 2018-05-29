<%-- 
    Document   : index
    Created on : May 25, 2018, 4:28:31 PM
    Author     : RAJESH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Available skills</h1>
        <ul>
        <c:forEach var="skill" items="${skills}">
        <li>${skill.name}</li>
        </c:forEach>
        </ul>
    </body>
</html>
