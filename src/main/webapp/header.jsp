<%--
  Created by IntelliJ IDEA.
  User: Kimi John
  Date: 2018/5/17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mobile Shop</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">


    <!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="fonts/font-slider.css" type="text/css">

    <!-- jQuery and Modernizr-->
    <script src="js/jquery-2.1.1.js"></script>

    <!-- Core JavaScript Files -->
    <script src="js/bootstrap.min.js"></script>

    <script src="js/photo-gallery.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>

    <![endif]-->
</head>
<body>
<!--Top-->
<nav id="top">
    <div class="container">
        <div class="row">
            <div class="col-xs-6">
                <%--<select class="language">--%>
                <%--<option value="English" selected>English</option>--%>
                <%--<option value="France">France</option>--%>
                <%--<option value="Germany">Germany</option>--%>
                <%--</select>--%>
                <%--<select class="currency">--%>
                <%--<option value="USD" selected>USD</option>--%>
                <%--<option value="EUR">EUR</option>--%>
                <%--<option value="DDD">DDD</option>--%>
                <%--</select>--%>
            </div>
            <div class="col-xs-6">
                <ul class="top-link">
                    <li><a href="account.jsp">
                        <span class="glyphicon glyphicon-user"></span>
                        <c:if test="${!empty sessionScope.user}">
                     ${sessionScope.user.username}
                        </c:if>
                        <c:if test="${empty sessionScope.user}">
                     点击登录
                        </c:if>
                    </a>

                    </li>
                    <c:if test="${!empty sessionScope.user}">
                    <li><a href="/showorder">我的订单</a></li>

                    <li><a href="/user_logout"> 注销</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!--Header-->
<header class="container">
    <div class="row">
        <div class="col-md-4">
            <div id="logo"><img src="images/logo.png"/></div>
        </div>
        <div class="col-md-4">
            <form class="form-search" action="search_goods" method="post">
                <input type="text" class="input-medium search-query" name="keyword"  placeholder="输入关键字:" >
                <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>
            </form>
        </div>
        <div class="col-md-4">
            <div id="cart"><a class="btn btn-1" href="cart_show"><span class="glyphicon glyphicon-shopping-cart"></span>购物车<span id="shoppingcount" >${cartnumber}</span> </a></div>
        </div>
    </div>
</header>
<!--Navigation-->
<nav id="menu" class="navbar">
    <div class="container">
        <div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>
            <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/homepage.jsp">主页</a></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">所有品牌</a>
                    <div class="dropdown-menu" style="margin-left: -203.625px;">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="moregoods?brandname=苹果">苹果</a></li>
                                <li><a href="moregoods?brandname=小米">小米</a></li>
                                <%--<li><a href="moregoods?brandname=一加">一加</a></li>--%>
                                <li><a href="moregoods?brandname=其他">其他</a></li>

                            </ul>
                            <ul class="list-unstyled">
                                <li><a href="moregoods?brandname=三星">三星</a></li>
                                <li><a href="moregoods?brandname=荣耀">荣耀</a></li>
                                <li><a href="moregoods?brandname=OPPO">OPPO</a></li>

                            </ul>
                            <ul class="list-unstyled">
                                <li><a href="moregoods?brandname=华为">华为</a></li>
                                <li><a href="moregoods?brandname=魅族">魅族</a></li>
                                <li><a href="moregoods?brandname=vivo">vivo</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li class="dropdown"><a href="/getNewPhone" >最新上架</a>
                    <%--<div class="dropdown-menu">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="category.html">Window</a></li>
                                <li><a href="category.html">MacBook</a></li>
                            </ul>
                        </div>
                    </div>--%>
                </li>
                <li class="dropdown"><a href="/getRanking" >推荐排行榜</a>

                </li>

                <%--<li><a href="">论坛</a></li>--%>
            </ul>
        </div>
    </div>
</nav>
