<%--
  Created by IntelliJ IDEA.
  User: yuxin
  Date: 2020/7/13
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    id:<input type="text" name="id"/><br>
    message:<input type="text" name="message"/><br>
    time:<input type="text" name="time"/><br>
    longitude:<input type="text" name="longitude"/><br>
    latitude:<input type="text" name="latitude"/><br>
    <input type="submit" value="Register"/>
    <input type="text" name="${_csrf.parameterName}" value="${_csrf.token}" />

</form>
</body>
</html>
