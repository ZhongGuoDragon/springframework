<%--
  Created by IntelliJ IDEA.
  User: yuxin
  Date: 2020/7/15
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sf:form commandName="spittle" method="post">
    id <sf:input path="id"/><br><sf:errors path="time" cssClass="error"/><br>
    message <sf:input path="message"/></br><sf:errors path="id" cssClass="error"/><br><br/>
    time <sf:input path="time"/><br></br><sf:errors path="message" cssClass="error"/><br><br/>
    latitude<sf:input path="latitude"/><br/><sf:errors path="latitude" cssClass="error"/><br><br/>
    longitude<sf:input path="longitude"/><br/><sf:errors path="longitude" cssClass="error"/><br><br/>
    <input type="submit" value="提交"/>
</sf:form>
<style type="text/css">
    /*body {background-color: red}*/
    /*p {margin-left: 20px}*/
    span.error{
        color:red;
    }
</style>

</body>
</html>
