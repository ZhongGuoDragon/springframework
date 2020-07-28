<%--
  Created by IntelliJ IDEA.
  User: yuxin
  Date: 2020/7/27
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get">
    count:<input type="text" name="count"><br>
    message:<input type="text" name="message"/></input><br>
    date:<input type="text" name="date"/><br>
    longitude:<input type="text" name="longitude"/><br>
    latitude:<input type="text" name="latitude"/><br>
    <input type="submit" name="submit" value="submit"/>
</form>

<%@include file="spittles.jsp"%>
</body>
</html>
