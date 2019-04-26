<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/26
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

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
    <link rel="stylesheet" type="text/css" href="../resource/css/managerChaxun.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/reset.css">
</head>
<body>
    <div class="beijing"></div>
    <div class="title">
        <p>查询信息</p>
    </div>
    <div class="shouye" onclick="history.go(-1);">返 回</div>


    <div class="left">
        <div class="huanyin ">❀❀❀管理用户❀❀❀</div>

        <div class="cha t" >管 理 用 户</div>
    </div>


    <div class="right a" style="display: block;z-index: 5;height: 420px;width: 750px;padding-bottom: 10px;" id="chaxun" >
        <div class="duzi">
            <div class="zuozuo">
                共 ${page.count}条记录，
                每页<input type="text" id="pagesize" value="${page.pageSize}" onchange="gotopage(1)" style="width: 30px" maxlength="3">条，
                共<fmt:formatNumber  type="number" value="${(page.count-page.count%page.pageSize)/page.pageSize+1}"/>页，
                当前第${page.pageNo}页  &nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="gotopage(${page.pageNo-1})" >上一页</a> &nbsp;

                <a href="javascript:void(0)" onclick="gotopage(${page.pageNo+1})" >下一页</a> &nbsp;

                跳转<input type="text" id="forwardPage" value="${page.pageNo}" style="width: 30px;" onchange="gotopage(this.value)">页


                <script type="text/javascript">
                    function gotopage(wantedPage) {
                        var pagesize = document.getElementById("pagesize").value;
                        window.location.href = "${pageContext.request.contextPath}/a/u1?loginName=${name}&pageNo="+wantedPage+"&pageSize="+pagesize;

                    }

                </script>
                <%--<form id="oBiaodan" action="../managerBlog.jsp">
                    <input type="submit" value="刷新">
                </form>
                <a href="/a/addUser.jsp?name=<%=request.getParameter("name")%>"><input type="button" value="增加" id="zz"></a>--%>
            </div>
            <div class="ooo">输出所有用户${name}   </div>
        <div>
        <%--<form id="sea" action="/a/SearchUser">
            <input type="text"  name="name" id="name"/>
            <input hidden type="text" name="dd" value="2">
            <input type="submit" value="查询" id="11"/>
        </form>--%>
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



                   <%
                       int dd1=1;
                       Object d;
                       d= request.getParameter("dd") ;
                    if(d==null)
                    {
                        dd1=2;
                    }
        %>
                <li class="newLi" style="width: 110px;">

                 <a href ="/a/deleteuser?id=${list.id}&name=${name}&dd=<%=dd1%>">删除</a>|<a href="/a/updateUser.jsp?id=${list.id}&name=${list.name}&dd=<%=dd1%>">更改</a>


                 </li>

         </ul>
        </c:forEach>
</div>
    </div>

<script type="text/javascript" src="../resource/js/managerChaxun.js"></script>

</body>
</html>
