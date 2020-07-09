<%--
  Created by IntelliJ IDEA.
  User: yuxin
  Date: 2020/6/1
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%></>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">主程序</div>
<jsp:include page="subPage.jsp">
    <jsp:param name="name" value="lisi"></jsp:param>
    <jsp:param name="age" value="20"/>
    <jsp:param name="电话" value="10086"/>
</jsp:include>
</body>
</html>
