<%--
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Blog" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/26
  Time: 14:30
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>管理用户</title>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
    <link rel="stylesheet" type="text/css" href="../resource/css/managerChaxun.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/reset.css">
    <link rel="icon" href="../resource/images/aoao.ico" type="img/x-ico" />
    <style type="text/css">
        .newLi{

            margin-left: 1px;
        }
         a{
          text-decoration: none;
          color: black;
       }
    </style>
</head>
<body>
<div class="beijing"></div>
<div class="title">
    <p>WELCOME  TO  BLUEMSUN</p>
</div>
<div class="shouye" onclick="history.go(-1);">返 回</div>


<div class="left">
    <div class="huanyin ">❀❀❀管理用户❀❀❀</div>

    <a href="#"><div class="kan t" id="kan">管 理 博 客</div></a>
    <div class="cha t" >管 理 用 户</div>
</div>


<div class="right a" style="display: block;z-index: 5;height: 400px;width: 750px;" id="chaxun" >
    <div class="duzi">
        <div class="zuozuo">
            共 ${page.count}条记录，
            每页<input type="text" id="pagesize" value="${page.pageSize}" onchange="gotopage(1)" style="width: 30px" maxlength="3">条，
            共<fmt:formatNumber  type="number" value="${(page.count-page.count%page.pageSize)/page.pageSize+1}"/>页，
            当前第${page.pageNo}页  &nbsp;&nbsp;
            <a href="javascript:void(0)" onclick="gotopage(${page.pageNo-1})" >上一页</a> &nbsp;

            <a href="javascript:void(0)" onclick="gotopage(${page.pageNo+1})" >下一页</a> &nbsp;

            跳转<input type="text" id="forwardPage" value="${page.pageNo}" style="width: 30px;" onchange="gotopage(this.value)">页

</body>

<script type="text/javascript">
    function gotopage(wantedPage) {
        var pagesize = document.getElementById("pagesize").value;
        window.location.href = "${pageContext.request.contextPath}/a/u1?loginName=${name}&pageNo="+wantedPage+"&pageSize="+pagesize;

    }

</script>
            <form id="oBiaodan" action="../managerBlog.jsp">
                <input type="submit" value="刷新">
            </form>
            <a href="/a/addUser.jsp?name=<%=request.getParameter("name")%>"><input type="button" value="增加" id="zz"></a>
        </div>
        <div class="ooo">输出所有用户${name}   </div>
<div>
     <form id="sea" action="/a/SearchUser">
         <input type="text"  name="name" id="name"/>
          <input type="submit" value="查询" id="11"/>
     </form>


</div>
        <ul>
            <li class="newLi" style="width: 45px;">学号</li>

            <li class="newLi" style="width: 100px;">昵称</li>
            <li class="newLi" style="width: 100px;">密码</li>
            <li class="newLi" style="width: 100px;">性别</li>
            <li class="newLi" style="width: 100px;">学院</li>
            <li class="newLi" style="width: 100px;">操作</li>

        </ul>

        <c:forEach items="${page.list}" var="list">
            <ul>
                <li class="newLi" style="width: 45px;"> ${list.id}</li>
                <li class="newLi" style="width: 160px;">
                    <a href="../news.html"><a href="../news.html">${list.loginName}</a></a>
                </li>
                <li class="newLi" style="width: 160px;">
                    <a href="../news.html">${list.psw}</a>
                </li>
                <li class="newLi" style="width: 160px;">
                    <a href="../news.html">${list.ses}</a>
                </li>
                <li class="newLi" style="width: 160px;">
                    <a href="../news.html">${list.acade}</a>
                </li>


                
                <li class="newLi" style="width: 100px;">
                    <a href ="/a/deleteuser?id=${list.id}&name=${name}">删除</a>|<a href="/a/updateUser.jsp?id=${list.id}&name=${list.loginName}">更改</a>
                </li>

            </ul>

        </c:forEach>
</div>
</div>

<div class="right" style="display:none;height: 500px;width: 750px; " id="zengjia">
    <div class="duzi">
        <div class="ooo">增加新闻</div>
        <form action="/a/add?name=${name}" name="add">
            <div class="iii">
                <div class="anews">
                    <p>标题</p>
                    <input type="text" name="title">
                </div>
                <div class="neirong" style="height: 30px;">
                    <p>发布人</p>
                    <input type="text" name="loginName" value="${name}">
                </div>
                <div  class="neirong">
                    <p>内容</p>
                    <textarea name="content" id="myEditor" >这里写你的初始化内容</textarea>
                    <script type="text/javascript">
                        //var editor = new UE.ui.Editor();
                        //editor.render("myEditor");
                        //1.2.4以后可以使用一下代码实例化编辑器
                        UEDITOR_CONFIG.UEDITOR_HOME_URL = './ueditor/';
                        UE.getEditor('myEditor');
                    </script>
                </div>
                <input type="submit" value="确认增加" class="yes" style="left: 640px;top: 420px;">
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="../resource/js/managerChaxun.js"></script>

</body>
</html>
-->--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/26
  Time: 14:30
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
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>管理用户</title>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
    <link rel="stylesheet" type="text/css" href="../resource/css/managerChaxun.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/reset.css">
    <link rel="icon" href="../resource/images/aoao.ico" type="img/x-ico" />
    <style type="text/css">
        .newLi{

            margin-left: 1px;
        }
        a{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<div class="beijing"></div>
<div class="title">
    <p>WELCOME  TO  BLUEMSUN</p>
</div>
<div class="shouye" onclick="history.go(-1);">返 回</div>


<div class="left">
    <div class="huanyin ">❀❀❀管理用户❀❀❀</div>

    <div class="cha t" >管 理 用 户</div>
</div>


<div class="right a" style="display: block;z-index: 5;height: 400px;width: 750px;" id="chaxun" >
    <div class="duzi">
        <div class="zuozuo">
            共 ${page.count}条记录，
            每页<input type="text" id="pagesize" value="${page.pageSize}" onchange="gotopage(1)" style="width: 30px" maxlength="3">条，
            共<fmt:formatNumber  type="number" value="${(page.count-page.count%page.pageSize)/page.pageSize+1}"/>页，
            当前第${page.pageNo}页  &nbsp;&nbsp;
            <a href="javascript:void(0)" onclick="gotopage(${page.pageNo-1})" >上一页</a> &nbsp;

            <a href="javascript:void(0)" onclick="gotopage(${page.pageNo+1})" >下一页</a> &nbsp;

            跳转<input type="text" id="forwardPage" value="${page.pageNo}" style="width: 30px;" onchange="gotopage(this.value)">页

</body>

<script type="text/javascript">
    function gotopage(wantedPage) {
        var pagesize = document.getElementById("pagesize").value;
        window.location.href = "${pageContext.request.contextPath}/a/u1?loginName=${name}&pageNo="+wantedPage+"&pageSize="+pagesize;

    }

</script>
<form id="oBiaodan" action="../managerBlog.jsp">
    <input type="submit" value="刷新">
</form>
<a href="/a/addUser.jsp?name=<%=request.getParameter("name")%>"><input type="button" value="增加" id="zz"></a>
</div>
<div class="ooo">输出所有用户${name}   </div>
<div>
    <form id="sea" action="/a/SearchUser">
        <input type="text"  name="name" id="name"/>
        <input type="submit" value="查询" id="11"/>
    </form>


</div>
<ul>
    <li class="newLi" style="width: 60px;">学号</li>

    <li class="newLi" style="width: 110px;">昵称</li>
    <li class="newLi" style="width: 110px;">密码</li>
    <li class="newLi" style="width: 110px;">性别</li>
    <li class="newLi" style="width: 110px;">出生日期</li>
    <li class="newLi" style="width: 110px;">操作</li>

</ul>

<c:forEach items="${page.list}" var="list">
    <ul>
        <li class="newLi" style="width: 60px;"> ${list.id}</li>
        <li class="newLi" style="width: 110px;">
            <a href="../news.html"><a href="../news.html">${list.name}</a></a>
        </li>
        <li class="newLi" style="width: 110px;">
            <a href="../news.html">${list.psw}</a>
        </li>
        <li class="newLi" style="width: 110px;">
            <a href="../news.html">${list.gender}</a>
        </li>
        <li class="newLi" style="width: 110px;">
            <a href="../news.html">${list.birDate}</a>
        </li>



        <li class="newLi" style="width: 110px;">
            <a href ="/a/deleteuser?id=${list.id}&name=${name}">删除</a>|<a href="/a/updateUser.jsp?id=${list.id}&name=${list.name}">更改</a>
        </li>

    </ul>
</c:forEach>
</div>
</div>

<script type="text/javascript" src="../resource/js/managerChaxun.js"></script>

</body>
</html>
