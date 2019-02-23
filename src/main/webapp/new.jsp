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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="header.jsp"/>
<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="breadcrumb">
                    <li><a href="/homepage.jsp">主页</a></li>
                    <li><a href="">最新上架</a></li>
                </ul>
            </div>
        </div>

        <div class="row" style="margin-left: 15px;">
            <c:forEach items="${newPhoneList}" var="phoneEntry">
                <%--<c:out value="${temp}"></c:out>--%>
                <div style="text-align: center;float: left;font-size: 16px">
                    <a href="/goods_detail?goodsid=${phoneEntry.goodsid}">
                        <img src="${phoneEntry.mainpic}" style="height: 280px;width: 280px"><br>
                        <span>${phoneEntry.title}</span>
                    </a><br>
                    <span style="color: red">￥${phoneEntry.price}</span>
                </div>
            </c:forEach>

        </div>

    </div>
</div>
<jsp:include page="footer.jsp"/>
