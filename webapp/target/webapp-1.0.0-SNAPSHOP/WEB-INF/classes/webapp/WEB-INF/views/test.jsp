<%--
  Created by IntelliJ IDEA.
  User: yuxin
  Date: 2020/6/1
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
    <meta content="text/html;charset=UTF-8" http-equiv="Content-Type"/>
</head>
<%
    String url="";
    int n = (int) (Math.random() * 10);
    int s = n % 2;
    if (s == 0) {
        url = "/index.jsp";
    } else {
        url = "index.jsp";
    }
%>
<body>
    <jsp:forward page="<%=url %>" />
</body>
</html>
