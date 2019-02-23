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
                    <li><a href="">推荐排行榜</a></li>
                </ul>
            </div>
        </div>

        <div class="">
            <table class="table table-bordered text-center" style="margin-left: 5px;">
                <tr style="text-align: center">
                    <th style="text-align: center">手机</th>
                    <th style="text-align: center">外观得分</th>
                    <th style="text-align: center">性能得分</th>
                    <th style="text-align: center">拍照得分</th>
                    <th style="text-align: center">用户评分</th>
                    <th style="text-align: center">综合得分</th>
                    <th style="text-align: center">排名</th>
                </tr>
                <c:forEach items="${ranking}" var="entry" varStatus="status">
                    <tr>
                        <td><a href="/goods_detail?goodsid=${entry.goodsid}" >${entry.title}</a></td>
                        <td>${entry.appearanceScore}</td>
                        <td>${entry.performanceScore}</td>
                        <td>${entry.photoScore}</td>
                        <td>${entry.userScore}</td>
                        <td>${entry.comprehensiveScore}</td>
                        <td>${status.count}</td>
                    </tr>
                </c:forEach>
            </table>


        </div>

            <%--<c:forEach items="${searchlist}" var="entry">
                <div class="row" style="height: 350px">
                    <div class="product well" style="margin-top: 30px;">
                        <div class="col-md-4">
                            <div class="image">
                                <img src="${entry.mainpic}"  style="width: 280px;height: 280px" />
                            </div>
                        </div>
                        <div class="col-md-8">

                            <div class="caption">
                                <div class="name"><h3><a href="/goods_detail?goodsid=${entry.goodsid}">${entry.title}</a></h3></div>
                                <div class="info">
                                </div>
                                <div class="price" style="color: red">￥${entry.price}</div>
                                <div class="info" style="height: 40px"><span>颜色：
                                    <c:if test="${entry.colorid eq 101}">金色
                                    </c:if>
                                    <c:if test="${entry.colorid eq 102}">银色
                                    </c:if>
                                    <c:if test="${entry.colorid eq 103}">玫瑰金
                                    </c:if>
                                    <c:if test="${entry.colorid eq 104}">黑色
                                    </c:if>
                                    <c:if test="${entry.colorid eq 105}">亮黑色
                                    </c:if>
                                    <c:if test="${entry.colorid eq 106}">红色特别版
                                    </c:if>
                                    <c:if test="${entry.colorid eq 107}">灰色
                                    </c:if>
                                    <c:if test="${entry.colorid eq 108}">蓝色
                                    </c:if>
                                    <c:if test="${entry.colorid eq 109}">粉色
                                    </c:if>
                                    <c:if test="${entry.colorid eq 110}">其他
                                    </c:if>
                                    </span>
                                </div>
                                <div><span>版本：
                                    <c:if test="${entry.colorid eq 101}">8GB
                                    </c:if>
                                    <c:if test="${entry.colorid eq 102}">16GB
                                    </c:if>
                                    <c:if test="${entry.colorid eq 103}">32GB
                                    </c:if>
                                    <c:if test="${entry.colorid eq 104}">64GB
                                    </c:if>
                                    <c:if test="${entry.colorid eq 105}">128GB
                                    </c:if>
                                    <c:if test="${entry.colorid eq 106}">256GB
                                    </c:if>
                                    <c:if test="${entry.colorid eq 107}">512GB
                                    </c:if>
                                    <c:if test="${entry.colorid eq 108}">其他
                                    </c:if>
                                </div>
                                <hr>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </c:forEach>--%>


    </div>
</div>
<jsp:include page="footer.jsp"/>
