<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/21
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Title</title>
</head>
<body>
<form action="/a/x" method="post">
    <input type="radio" name="x" value="1" >插入
    <input type="radio" name="x" value="2" >查找
    <input type="radio" name="x"value="3" >删除
    <input type="radio" name="x" value="4" >修改
    <input type="radio" name="x" value="5" >输出
    <input type="radio" name="x" value="6" >退出
    <input type="submit" >提交
</form>
</body>
</html>