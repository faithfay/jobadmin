<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>上映電影電子報</title>
</head>
<body>

<form action="list">
    <input type="search" name="mname">
    <input type="submit">
</form>

<table>
    <thead>
        <tr>
            <th>pkid</th>
            <th>mname</th>
            <th>checkdate</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${movielist}" var="movie">
            <tr>
                <td>${movie.pkid}</td>
                <td><a href="${movie.murl}" title="${movie.mname}">${movie.mname}</a></td>
                <td>${movie.checkdate}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
