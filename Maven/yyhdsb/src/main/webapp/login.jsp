<%--
  Created by IntelliJ IDEA.
  User: houchang
  Date: 2019-07-24
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="loginServlet" method="post" >
        username:<input type="text" name="username"/><br>
        password:<input type="password" name="password"/><br>
        <input type="submit" value="submit">
        <input type="reset" value="reset">
    </form>
</body>
</html>
