<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en" xmlns:c="http://www.w3.org/1999/html">
<jsp:include page="header.jsp"/>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Cart Page//////////////////////-->
	<!--//////////////////////////////////////////////////-->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="/homepage.jsp">主页</a></li>
						<li><a href="/order.jsp">订单</a></li>
					</ul>
				</div>
			</div>

				<%--订单为空--%>
			<c:if test="${empty orderlist}">
				<span style="text-align:center"><h2>没有订单！</h2></span>

			</c:if>
				<%--订单	不为空--%>
			<c:if  test="${!empty orderlist}">
			<c:forEach items="${orderlist}" var="orderentry" varStatus="status">
				<div  class="">
					<table  class="table table-bordered"  style="text-align: center;margin-left: 5px">
						<tr>
							<td >订单号：${orderentry.orderid}</td>
							<td colspan="2"> 订单创建时间：${orderentry.creattime}</td>
							<td>订单状态：
								<%--${orderentry.orderstatus}--%>
								<c:if test="${orderentry.orderstatus eq 0}">未支付
								</c:if>
								<c:if test="${orderentry.orderstatus eq 1}">等待发货
								</c:if>
								<c:if test="${orderentry.orderstatus eq 2}">运输中
								</c:if>
								<c:if test="${orderentry.orderstatus eq 3}">订单完成
								</c:if>
							</td>
							<td> 订单总额：${orderentry.paysum}</td>
						</tr>
						<tr><td colspan="5">物流信息：收货人：${user.username} 手机：${user.phone} 收货地址：${user.address}</td></tr>
						<tr>
							<td>手机</td>
							<td>标题</td>
							<td>单价</td>
							<td>数量</td>
							<td>小计</td>
						</tr>
						<c:forEach  items="${orderentry.ordergoodslist}" var="entry">
							<tr>
								<td> <img src="${entry.ordergoodspic}"  style="width: 58px;height: 58px" /></td>
								<td>${entry.ordergoodstitle}</td>
								<td>${entry.ordergoodsprice}</td>
								<td>${entry.ordergoodscount}</td>
								<td>${entry.ordergoodspayment}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5">

								<c:if test="${orderentry.orderstatus eq 0}">
									<a href="/payoff?orderid=${orderentry.orderid}"  class="btn btn-2" style="margin-left: 500px">立即支付</a>
								</c:if>

								<c:if test="${orderentry.orderstatus eq 2}">
									<a href="/orderReceipt?orderid=${orderentry.orderid}"  class="btn btn-2" style="margin-left: 500px">确认收货</a>
								</c:if>

							</td>
						</tr>

					</table>

				</div>


			</c:forEach>

			</c:if>



		</div>
	</div>
<jsp:include page="footer.jsp"/>
