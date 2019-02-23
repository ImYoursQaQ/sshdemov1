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
						<li><a href="#">订单确认</a></li>
					</ul>
				</div>
			</div>
			<%--内容界面--%>
			<div class="row">
				<div class="col-lg-12">
					<div class="caption">
						<div class="name"><h2>确认用户信息</h2></div>
						<div class="info">
							<h5 style="color: red">
						<p>${user.username}   ${user.phone}  ${user.address}</p></h5>
						</div>

						<hr>

					</div>
					<div class="caption">
						<div class="name"><h2>确认商品信息</h2></div>
						<div class="info">
						<table class="table table-bordered"  style="text-align: center;margin-left: 5px">
							<tr>
								<th style="text-align: center">手机</th>
								<th style="text-align: center">标题</th>
								<th style="text-align: center">单价</th>
								<th style="text-align: center">数量</th>
								<th style="text-align: center">小计</th>
							</tr>
							<c:forEach  items="${order.ordergoodslist}" var="entry">
							<tr>
								<td> <img src="${entry.ordergoodspic}"  style="width: 58px;height: 58px" /></td>
								<td>${entry.ordergoodstitle}</td>
								<td>${entry.ordergoodsprice}</td>
								<td>${entry.ordergoodscount}</td>
								<td>${entry.ordergoodspayment}</td>
							</tr>
							</c:forEach>
						</table>
							


						</div>

						<hr>

					</div>
					<div class="pricedetails">
						<div class="col-md-4 col-md-offset-8">
							<table  style="width: 272px;">
                                <tr>
                                    <td style="width: 135px">商品总价</td>
                                    <td>${order.payment}</td>
                                </tr>
                                <tr>
                                    <td>运送费</td>
                                    <td>${order.postfee}</td>
                                </tr>
                                <tr style="border-top: 1px solid #333">
                                    <td ><h5 style="width: 135px">实际支付</h5></td>
                                    <td>${order.paysum}</td>
                                </tr>
                            </table>
							<center><a href="/submitOrder" class="btn btn-1">提交订单</a></center>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>	
	<footer>
		<div class="container">
			<div class="wrap-footer">
				<div class="row">
					<div class="col-md-3 col-footer footer-1">
						<img src="images/logofooter.png" />
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
					</div>
					<div class="col-md-3 col-footer footer-2">
						<div class="heading"><h4>Customer Service</h4></div>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="#">Delivery Information</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Terms & Conditions</a></li>
							<li><a href="#">Contact Us</a></li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-3">
						<div class="heading"><h4>My Account</h4></div>
						<ul>
							<li><a href="#">My Account</a></li>
							<li><a href="#">Brands</a></li>
							<li><a href="#">Gift Vouchers</a></li>
							<li><a href="#">Specials</a></li>
							<li><a href="#">Site Map</a></li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-4">
						<div class="heading"><h4>Contact Us</h4></div>
						<ul>
							<li><span class="glyphicon glyphicon-home"></span>California, United States 3000009</li>
							<li><span class="glyphicon glyphicon-earphone"></span>+91 8866888111</li>
							<li><span class="glyphicon glyphicon-envelope"></span>infor@yoursite.com</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						Copyright &copy; 2018.Company hu All rights reserved.
					</div>
					<div class="col-md-6">
						<div class="pull-right">
							<ul>
								<li><img src="images/visa-curved-32px.png" /></li>
								<li><img src="images/paypal-curved-32px.png" /></li>
								<li><img src="images/discover-curved-32px.png" /></li>
								<li><img src="images/maestro-curved-32px.png" /></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
