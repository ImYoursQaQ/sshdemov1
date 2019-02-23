<%--
  Created by IntelliJ IDEA.
  User: Kimi John
  Date: 2018/3/20
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>后台管理系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="./vendor1/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="./vendor1/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./dist1/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="./vendor1/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        body {background-image:url("/image/background.jpg");}
    </style>
</head>
<body  style="text-align: center;"><%--
<div id=" login_body" style="width: auto;margin-top: 200px;">
    <h2>管理员登录</h2>
<form action="admin_login" method="post" style="font-size: 25px">
    &lt;%&ndash;<input type="text" name="user.username" placeholder="输入用户名" />&ndash;%&gt;
    &lt;%&ndash;<br/>&ndash;%&gt;
    &lt;%&ndash;<input type="password" name="user.password" placeholder="输入密码" />&ndash;%&gt;
    &lt;%&ndash;<br />&ndash;%&gt;
    <input type="text" name="admin.adminName" placeholder="输入用户名" />
    <br/>
    <input type="password" name="admin.adminPassword" placeholder="输入密码" />
    <br />
    <input type="submit" value="登录">
    <input type="reset" value="重置">
        <br />
</form>
没有账户，<a href="/jsp/register.jsp">点此注册</a>
</div>--%>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">管理员登录</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="admin_login" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="用户名" name="admin.adminName" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="admin.adminPassword" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                           <%-- <a href="index.html" class="btn btn-lg btn-success btn-block">登录</a>--%>
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="登录">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="./vendor1/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="./vendor1/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="./vendor1/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="./dist1/js/sb-admin-2.js"></script>
</body>
</html>
