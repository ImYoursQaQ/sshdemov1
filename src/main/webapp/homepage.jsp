<%--
  Created by IntelliJ IDEA.
  User: Kimi John
  Date: 2018/5/17
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="header.jsp"/>
<div id="page-content" class="single-page">
    <div class="container">

        <div class="row">
            <div class="col-lg-12">
                <!-- Carousel -->
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators hidden-xs">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <a href="/goods_detail?goodsid=${posterList[0].goodsid}">
                            <img src="${posterList[0].posterPath}" alt="First slide" style="height: 360px;width: 1140px;">
                            </a>
                            <!-- Static Header -->
                            <div class="header-text hidden-xs">
                                <div class="col-md-12 text-center">
                                </div>
                            </div><!-- /header-text -->
                        </div>
                        <div class="item">
                            <a href="/goods_detail?goodsid=${posterList[1].goodsid}">
                            <img src="${posterList[1].posterPath}" alt="Second slide" style="height: 360px;width: 1140px;">
                            </a>
                                <!-- Static Header -->
                            <div class="header-text hidden-xs">
                                <div class="col-md-12 text-center">
                                </div>
                            </div><!-- /header-text -->
                        </div>
                        <div class="item">
                            <a href="/goods_detail?goodsid=${posterList[2].goodsid}">
                            <img src="${posterList[2].posterPath}" alt="Third slide" style="height: 360px;width: 1140px;">
                            </a>
                                <!-- Static Header -->
                            <div class="header-text hidden-xs">
                                <div class="col-md-12 text-center">
                                </div>
                            </div><!-- /header-text -->
                        </div>
                    </div>
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div><!-- /carousel -->
            </div>
        </div>
       <%-- <div class="row">
            <div class="col-lg-12">
                <ul class="breadcrumb">
                    <li><a href="/homepage.jsp">主页</a></li>
                </ul>
            </div>
        </div>--%>

        <div class="row">

            <div id="zhuti">
                <c:forEach items="${result}" var="entry">
                    <div id="${entry.key}" class="col-lg-12">
                        <div id="info">
                            <div class="breadcrumb">
                                <span>${entry.key}</span>
                                <a class="col-md-offset-11" href="moregoods?brandname=${entry.key}"
                                   methods="post">更多</a>
                            </div>
                            <div>
                                <c:forEach items="${entry.value}" var="temp">
                                    <%--<c:out value="${temp}"></c:out>--%>
                                    <div style="text-align: center;float: left;font-size: 16px">
                                        <a href="/goods_detail?goodsid=${temp.goodsid}">
                                            <img src="${temp.mainpic}" width="280px" height="280px"><br>
                                            <span>${temp.title}</span>
                                        </a><br>
                                        <span style="color: red">￥${temp.price}</span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
