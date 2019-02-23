<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Kimi John--%>
  <%--Date: 2018/5/4--%>
  <%--Time: 9:48--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>产品详情</title>--%>
<%--</head>--%>
<%--<body style="text-align: center;margin-top:  0;margin-left: 0;margin-right: 0">--%>
<%--<div id="head" style="margin-top: 0px;margin-left: fill">--%>
    <%--<jsp:include page="/jsp/head.jsp"></jsp:include>--%>
<%--</div>--%>
<%--<div id="goodstext">--%>
    <%--<c:out value="${goods}"/>--%>
    <%----%>
    <%--<img src="/image/">--%>
    <%--<span>标题</span>--%>
    <%--<span>价格</span>--%>
<%--<span>颜色</span>--%>
<%--<span>版本</span>--%>

    <%--<button> 加入购物车</button>--%>




<%--</div>--%>

<%--<div id="goodsdetail"></div>--%>





<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品详情</title>
    <style type="text/css">
        /*body {*/
            /*background-image: url("/image/background.jpg");*/
        /*}*/
    </style>
    <style>
        A {
            text-decoration: NONE
        }
    </style>
</head>
<body style="margin-top:  0;text-align: center;margin-left: 0;margin-right: 0">
<div id="head" style="margin-top: 0px;margin-left: fill;">
    <jsp:include page="/jsp/head.jsp"></jsp:include>
</div>

    <%--<div id="navigation" style="height: 20px">--%>

    <%--<a href="/jsp/homepage.jsp">首页</a>--%>
    <%--</div>--%>


    <div>

    </div>

    <%--主体部分--%>
    <div id="zhuti" style="width: 1400px">
        <div id="goodstext" style="width: 1400px">

            <div style="width: 50%;float: left;background-color: white">
            <img src="${goods.mainpic}" width="500px">
            </div>
            <div style="width: 700px;height: 400px;float: left;text-align: center;background-color: white">
            <span style="font-size: 20px;font-weight: bold">${goods.title}</span><br><br><br>
                <span>参考价格：</span>
            <span style="color: red;font-size: 16px">${goods.price}</span><br><br><br><br>
                <span>颜色：</span>
            <span>${phonecolor.colorname}</span><br><br><br><br>
                <span>版本：</span>
            <span>${rom.roMcapacityname}</span><br><br><br><br>

            <button style="font-size: 30px ;background-color: red"> 加入购物车</button>
            </div>

        </div>

        <div id="detailgoods"></div>






    </div>


</div>
<div id="buttom" style="margin-bottom: 0px">
    这是公共底部
</div>
</body>
</html>
