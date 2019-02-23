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
						<li><a href="#">购物车</a></li>
					</ul>
				</div>
			</div>

			<c:if test="${!empty cartlist}">
				<%--购物车不为空--%>
			<c:forEach items="${cartlist}" var="entry">
			<div class="row">
				<div class="product well">
					<div class="col-md-4">
						<div class="image">
							<img src="${entry.mainpic}"  style="width: 280px;height: 280px" />
						</div>
					</div>
					<div class="col-md-8">

						<div class="caption">
							<div class="name"><h3><a href="product.html">${entry.title}</a></h3></div>
							<div class="info">	

							</div>
							<div class="price" style="color: red">￥${entry.price}</div>
							<label>数量: </label> <span>${entry.count}</span>
							<hr>
							<form action="delCart?goodsid=${entry.goodsid}&userid=${user.userid}" method="post">
							<input type="submit"  class="btn btn-default pull-right" value="删除">
							<%--<a href="#" class="btn btn-default pull-right">删除</a>--%>
							</form>
						</div>
					</div>
					<div class="clear"></div>
				</div>	
			</div>
			</c:forEach>


			<div class="row">
				<div class="col-md-4 col-md-offset-8 " style="float: left">
					<center><a href="/homepage.jsp" class="btn btn-1">继续购物</a></center>
				</div>
			</div>
			<div class="row">
				<div class="pricedetails">
					<div class="col-md-4 col-md-offset-8">
						<center><a href="/checkout" class="btn btn-1">立即结算</a></center>
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${empty cartlist}">
				<%--购物车为空--%>
					<div class="row" style="text-align:center">
						<div class="col-md-12">
							<span style="text-align:center" ><h2>购物车里没有商品！</h2></span>
							<center><a href="/homepage.jsp" class="btn btn-1" style="text-align:center">立即购物</a></center>
						</div>
					</div>

			</c:if>
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
