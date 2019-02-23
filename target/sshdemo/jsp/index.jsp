<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>手机商城主页</title>
    <style type="text/css">
        body {
            background-image: url("/image/background.jpg");
        }
    </style>
    <style>
        A {
            text-decoration: NONE
        }
    </style>
</head>
<body style="text-align: center;margin-top:  0;margin-left: 0;margin-right: 0">
<div id="head" style="margin-top: 0px;margin-left: fill">
    <jsp:include page="/jsp/head.jsp"></jsp:include>
</div>
<div id="body"
     style="background: cornsilk;width: 1400px;text-align: center;margin: auto;padding-top: 10px">
    <div id="search" style="height: 40px">
        <form action="">
            <input type="text"> <input type="submit" value="搜索">
        </form>
    </div>
    <%--<div id="navigation" style="height: 20px">--%>

    <%--<a href="/jsp/homepage.jsp">首页</a>--%>
    <%--</div>--%>

    <div id="recommend" style="background: white;height: 100px;margin: 0px;padding: 0px">
        这是产品推荐部分
    </div>
    <div>

    </div>
    <div id="theme">
        <a href="#apple">苹果</a> &nbsp;
        <a href="">三星</a>&nbsp;
        <a href="">华为</a>&nbsp;
        <a href="#小米">小米</a>&nbsp;
        <a href="">魅族</a>&nbsp;
        <a href="">荣耀</a>&nbsp;
        <a href="">一加</a>&nbsp;
        <a href="">OPPO</a>&nbsp;
        <a href="">vivo</a>&nbsp;
        <a href="">其他</a>&nbsp;

    </div>
    <%--主体部分--%>
    <div id="zhuti">
        <c:forEach items="${result}" var="entry">
            <div id="${entry.key}" style="height: 414px">
                <div id="title" style="height: 50px;background:skyblue;font-size: 30px">
                    <span style="margin-left:5px;margin-right: 600px">${entry.key}</span>
                    <a href="" style="margin-right: 5px;margin-left: 600px">更多</a>
                    <div style="background: beige;">
                        <c:forEach items="${entry.value}" var="temp">
                            <%--<c:out value="${temp}"></c:out>--%>
                            <div style="text-align: center;width: 350px;float: left;background: white;font-size: 16px">
                                <a href="/goods_detail?goodsid=${temp.goodsid}" >
                                    <img src="${temp.mainpic}" width="320px" height="320px"><br>
                                    <span>${temp.title}</span>
                                </a><br>
                                <span style="color: red">￥${temp.price}</span>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:forEach>

        <%--<c:forEach items="${brands}" var="brandsitem" varStatus="status">--%>
        <%--<div id="${brandsitem.brandname}" style="height: 414px">--%>
        <%--<div id="title" style="height: 50px;background:skyblue;font-size: 30px">--%>
        <%--<span style="margin-left:5px;margin-right: 600px">${brandsitem.brandname}</span>--%>
        <%--&lt;%&ndash;<span style="margin-left:5px;margin-right: 600px">${brandsitem.brandid}</span>&ndash;%&gt;--%>
        <%--<a href="" style="margin-right: 5px;margin-left: 600px">更多</a>--%>
        <%--</div>--%>
        <%--<div style="background: beige;">--%>
        <%--&lt;%&ndash;<c:out value="goods${status.count}"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:set var="nihao" value="goods${status.count}"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:out value="${status.count}"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:out value="${nihao}"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:out value="${goods1}"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:forEach items="${goods1}" var="goodsitem">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:out var="goodscount" value = "goods${status.count}"/>&ndash;%&gt;--%>
        <%--<c:forEach items="${goods101}" var="goodsitem">--%>
        <%--<div style="text-align: center;width: 350px;float: left;background: white">--%>
        <%--<a href="" action="detailAction" method="detailOfGoods">--%>
        <%--<img src="${goodsitem.mainpic}" width="320px" height="320px"><br>--%>
        <%--<span>${goodsitem.title}</span>--%>
        <%--</a><br>--%>
        <%--<span style="color: red">￥${goodsitem.price}</span>--%>
        <%--</div>--%>
        <%--</c:forEach>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</c:forEach>--%>
        <div id="sanxing">
            这是产品预览部分
        </div>
        <div id="huawei">
            这是产品预览部分
        </div>
        <div id="xiaomi">
            这是产品预览部分
        </div>

    </div>


</div>
<div id="buttom" style="margin-bottom: 0px">
    这是公共底部
</div>
</body>
</html>