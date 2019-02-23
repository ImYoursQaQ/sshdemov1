<%--
  Created by IntelliJ IDEA.
  User: Kimi John
  Date: 2018/3/21
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style type="text/css">
        body {background-image:url("/image/background.jpg");text-align: center;}
    </style>
</head>
<body>
<div id="register_body" style="width: 300px;margin-left: auto;margin-right: auto;margin-top: 50px;background: cornsilk">
    <h2>用户注册</h2>
    <form action="user_register" method="post" style="font-size: 25px;" >

        <div style="color: red">${sessionScope.errorMessage}</div>
        <input type="text" name="user.username" placeholder="用户名" />
        <br/><br>
        性别： 男 <input type="radio" name="user.gender" value="0"/>
              女 <input type="radio" name="user.gender" value="1"/>
        <br><br>
        <input type="password" name="user.password" placeholder="密码" />
        <br /><br>
        <input type="password" name="password2" placeholder="密码确认" />
        <br/><br>
        <input type="text" name="user.phone" placeholder="电话号码" />
        <br /><br>
        <input type="text" name="user.email" placeholder="邮箱" />
        <br/><br>

        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
    返回<a href="/jsp/login.jsp">登录</a>
</div>

</body>
</html>
