<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/26
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <meta charset="UTF-8">
    <title>蓝旭工作室</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
    <link rel="stylesheet" type="text/css" href="../resource/css/managerChaxun.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/reset.css">
    <link rel="icon" href="../resource/images/aoao.ico" type="img/x-ico" />
    <style type="text/css">
    </style>
</head>
<body>
<div class="beijing"></div>
<div class="title">
    <p>WELCOME  TO  BLUEMSUN</p>
</div>
<a href="index.html" class="ozn"><div class="shouye">返回首页</div></a>

<div class="left">
    <div class="huanyin ">❀❀❀管理员，欢迎你❀❀❀</div>
    <div class="cha t" >返 回 新 闻</div>

</div>


<div class="right a">
    <div class="duzi">
        <div class="ooo">更新用户</div>

        <form action="/a/updateuser?id=<%=request.getParameter("id")%>" name="change">

            <div class="iii">

                    <input   hidden type="text" name="id11" value=<%=request.getParameter("id")%>>

                <div class="anews">
                    <p>学号</p>
                    <input type="text" name="id" value=<%=request.getParameter("id")%>>
                </div>
                <div class="anews">
                    <p>用户名</p>
                    <input type="text" name="name" value=<%=request.getParameter("name")%>>
                </div>


                <div class="neirong">
                    <p>密码</p>
                    <input type="text" name="psw">
                </div>


                <div class="neirong">
                    <p>性别</p>
                    <input name="ses"  type="radio" checked/>男
                    <input name="ses" type="radio" />女
                </div>

                <div class="neirong">
                    <p>出生日期</p>
                    <input type="text" name="acade">
                </div>





            </div>
            <div> <input type="submit" value="确认更改111" class="yes"></div>
        </form>
    </div>
</div>
<script type="text/javascript">
    var fanhui=document.getElementById('fanhui');
    fanhui.onclick=function(){
        window.parent.location.href='../managerChaxun.html';
    }
</script>
</body>
</html>