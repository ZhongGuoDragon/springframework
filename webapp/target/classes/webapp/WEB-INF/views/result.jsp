<%--
  Created by IntelliJ IDEA.
  User: yuxin
  Date: 2020/7/13
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H6>result</H6>
<h1><c:out value="${spittle.id}"/></h1>
    <li id="spittle-<c:out value="spittle.id"/>">
    <div class="spittleMessage">
    <c:out value="${spittle.message}"/>
    </div>
    <div>
    <span class="spittlTime"><c:out value="${spittle.time}"/></span>
    <span class="spittleLocation">
    (<c:out value="${spittle.latitude}"/>
    <c:out value="${spittle.longitude}"></c:out>)
    </span>
    </div>

    </li>

</body>
</html>
