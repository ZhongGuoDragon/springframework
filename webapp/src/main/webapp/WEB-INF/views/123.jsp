<%--
  Created by IntelliJ IDEA.
  User: yuxin
  Date: 2020/6/1
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/back" method="post">
    <tr>
        <td>name:</td>
        <td><input type="text" name="name" value=""></td>
    </tr>
    <tr>
        <td>city:</td>
        <td><input type="text" name="city" value=""></td>
    </tr>
    <input type="submit" name="tijiao" value="hehe">
</form>
<%request.setAttribute("hehe","hhhh");
    request.setAttribute("hhhh","mmmm");
    request.removeAttribute("hhhh");
    request.setAttribute("name","1111111111");

%>
</body>
</html>
