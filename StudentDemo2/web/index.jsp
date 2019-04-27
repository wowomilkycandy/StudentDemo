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
    <title>首页</title>
    <link rel="stylesheet" href="resource/css/little.css"/>

</head>
<body>
<h1>键盘输入对应序号后点击确认按钮或者敲击回车键</h1>
<form action="/a/x" method="post">
    <p>1</p>插入
    <p>2</p>查找
    <p>3</p>删除一个
    <p>4</p>修改
    <p>5</p>输出
    <p>6</p>退出
    <p>7</p>删除多个
    <p>8</p>修改多个
    <input type="hidden" id="invisible" name="x">
    <input type="submit" id="su">
</form>
<script type="text/javascript" src="resource/js/getKey.js"></script>
</body>
</html>
