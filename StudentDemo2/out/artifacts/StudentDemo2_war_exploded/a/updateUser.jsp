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
    <title>更新用户</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="../resource/css/managerChaxun.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/reset.css">
    <%--<link rel="icon" href="../resource/images/aoao.ico" type="img/x-ico" />--%>
</head>
<body>
    <div class="beijing"></div>
    <div class="title">
        <p>更新信息</p>
    </div>
    <a href="index.jsp" class="ozn"><div class="shouye">返回首页</div></a>

    <div class="left">
        <div class="huanyin ">❀❀❀欢迎你❀❀❀</div>
        <div class="cha t" >更新用户</div>
    </div>


    <div class="right a">
        <div class="duzi">
            <div class="ooo">更新用户</div>

            <form action="/a/updateuser?id=<%=request.getParameter("id")%>" name="change">

                <div class="iii">

                    <input   hidden type="text" name="id11" value=<%=request.getParameter("id")%>>



                    <input type="text" name="id"  hidden  value=<%=request.getParameter("id")%>>

                    <div class="anews">
                        <p class="use">用户名</p>
                        <input type="text" name="name1" value=<%=request.getParameter("name")%>>

                    </div>


                    <div class="neirong">
                        <p class="use">密码</p>
                        <input type="text" name="psw">
                    </div>


                    <div class="neirong">
                        <p class="use">性别</p>
                        <input name="ses"  type="radio"value="男" checked/>男
                        <input name="ses" type="radio"  value="女"/>女
                    </div>

                    <div class="neirong">
                        <p class="use">出生日期</p>
                        <input type="text" name="acade">
                    </div>
                </div>

                <div>
                    <input  hidden  name="dd" value="<%=request.getParameter("dd")%>"  >
                    <input  hidden  name="dd1" value="${dd1}"  >
                    <input type="submit" value="确认修改" class="confirm">
                </div>
                <input type="text"  hidden name="name11" value=<%=request.getParameter("name")%>>
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