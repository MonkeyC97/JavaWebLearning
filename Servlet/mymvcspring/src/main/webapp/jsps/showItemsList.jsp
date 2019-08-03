<%--
  Created by IntelliJ IDEA.
  User: houchang
  Date: 2019-08-03
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th>ItemsId</th>
        <th>ItemsName</th>
        <th>ItemsPrice</th>
    </tr>

    <c:forEach items="${itemsListKey}" var="items">
        <tr>
            <td>${items.itemsId}</td>
            <td>${items.itemsName}</td>
            <td>${items.itemsPrice}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
