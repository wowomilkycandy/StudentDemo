<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/26
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html >
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>添加用户</title>
    <%--<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="../resource/css/managerChaxun.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/reset.css">
    <%--<link rel="icon" href="../resource/images/aoao.ico" type="img/x-ico" />--%>
</head>
<body>

<a href="index.jsp" class="ozn"><div class="shouye">返回首页</div></a>



        <div class="container">


        <div class="title1" >增加用户</div>

        <form action="/a/au" name="change" method="post">
            <div >
                <p>学号</p>
                <input type="text" name="ids" >
            </div>
            <div  >
                <p>用户名</p>
                <input type="text" name="name" >
            </div>


            <div >
                <p>  密码</p>
                <input type="text" name="psw"%>
            </div>

            <div >
                 <p>性别：</p>
                <input name="ses"  type="radio" checked value="男">男</input>
                    <input name="ses" type="radio" value="女"  >女</input>
            </div>

            <div >
                <p> 生日</p>
                <input type="text" name="acade"%>
            </div>


            <div> <input type="submit"  placeholder="确认添加"  class="yes"></div>
        </form>

</div>







</body>
</html>