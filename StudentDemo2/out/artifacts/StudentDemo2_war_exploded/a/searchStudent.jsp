<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/22
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>

<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../resource/css/managerChaxun.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/reset.css">
    <title>查询用户</title>
</head>
<body>
    <form action="/a/SearchUser" class="form1">
<%
boolean dd1= Boolean.parseBoolean(request.getParameter("dd1"));
%>
        <input type="text" name="name" >
        <input hidden type="text" name="dd" value="1">
        <input hidden type="text" name="dd1" value="${dd1}">
        <p>请输入姓名</p>
        <input type="submit" value="提交" class="yes2" >
        <a href="../index.jsp">返回</a>
    </form>
</body>
</html>
