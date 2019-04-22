<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/13
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="resource/css/load.css">
    <link rel="stylesheet" type="text/css" href="resource/css/reset.css">
    <link rel="icon" href="resource/images/aoao.ico" type="img/x-ico" />
    <style type="text/css">
        .zhuce:hover{background-color: rgba(0,170,255,0.4);}
        .load:hover{background-color: rgba(0,170,255,0.4);}
        .newLi{
            background-color: pink;
        }
    </style>



</head>


<body onload="createCode()">
<div class="beijing"></div>
<div class="main" >
    <!-- 注册成功 -->
    <div class="oBlack" id="oBlack">
        <div class="zhongjian">
            <div class="zizizi">
                <span>❀❀❀恭喜你注册成功，欢迎来到蓝旭❀❀❀</span>
            </div>
            <div class="wenwen">
                <span class="aoao">(<span id="shu">3</span>秒后页面自动跳转到首页)</span>
            </div>
        </div>
    </div>
    <div class="title">
        <p>WELCOME  TO  BLUEMSUN</p>
    </div>
    <div class="mainbody">
        <div class="zhuce" id="load">注 册</div>
        <div class="load" id="zhuce">登 录</div>
        <!-- 登录 -->

        <div class="duzi" id="duzi">
            <div class="kuai">
                <form action="/f/login"  method="POST">
                    <div class="miao">
                        <p>用户名：</p>


                        <input type="text" name="userName">
                    </div>
                    <div class="jun">
                        <p>密 码：</p>
                        <input type="password" name="psw">

                    </div>
                    <input type="submit" class="oo" value="登    录">
                    <!-- <a href="" class="gai">修改密码</a> -->
                </form>
            </div>
        </div>
        <!-- 注册 -->
        <div class="duzii" id="duzii">
            <form id="oBiaodan" action="/f/region" method="post">
                <div class="yangshi t">
                    <p>学号：</p>
                    <input type="text" name="id"  placeholder="请输入不小于2个字符"  >
                    <span class= ></span>
                </div>
                <div class="yangshi t">
                    <p>用户名：</p>
                    <input type="text" name="username"  placeholder="请输入不小于2个字符" class="oInput">
                    <span class="oSpan"></span>
                </div>
                <div class="yangshi">
                    <p>密 码 :</p>
                    <input type="password" name="psw" placeholder="密码必须大于6个字符" class="oInput">
                    <span class="oSpan"></span>

                </div>

                <div class="yangshi">
                    <p>确认密码：</p>
                    <input type="password" name="psw1" class="oInput" disabled="disabled">
                    <span class="oSpan">*两次密码输入不一致</span>
                </div>
                <div  class="yangshi t">
                    <p>出生日期：</p>
                    <input type="text" name="acade"   >
                    <span  ></span>
                </div>
                <div  class="yangshi t">
                    <p>性别：</p>
                    <input type="text" name="ses"   >
                    <span  ></span>
                </div>
                <!--  <div class="yangshi">
                   <p>手机号：</p>
                   <input type="text" name="username" placeholder="请输入正确中国大陆手机号" class="oInput">
                   <span class="oSpan">*请输入正确中国大陆手机号</span>
                </div> -->
                <div class="yangshi">
                    <p>验证码：</p>
                    <input type="text" name="username" class="oInput">
                    <span class="oSpan"></span>
                </div>
                <div class="yanzheng">
                    <div class="mm">
                        <div class="ma" onclick="createCode()" id="checkCode"></div>
                    </div>
                    <a href="#" onclick="createCode()">看不清楚，换一张</a>
                </div>
                <input type="button" class="submit" id="tijiao" value="注册" onclick="qwen();">
                <!-- <input type="submit" name="submit" class="submit" id="tijiao" value="注册"> -->
            </form>
        </div>

    </div>
</div>
<script type="text/javascript" src="resource/js/load.js"></script>
</body>
</html>
