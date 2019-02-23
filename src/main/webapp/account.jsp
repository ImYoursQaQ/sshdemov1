<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="header.jsp"/>
<!--//////////////////////////////////////////////////-->
<!--///////////////////Product Page///////////////////-->
<!--//////////////////////////////////////////////////-->
<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="breadcrumb">
                    <li><a href="/homepage.jsp">主页</a></li>
                    <li><a href="/account.jsp">我的账户</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div id="main-content" class="col-md-12">

                <c:if test="${empty sessionScope.user}">

                <div class="col-md-6">
                    <div class="heading"><h2>登录</h2></div>
                    <span style="color: red">${errormessage}</span>
                    <form name="form1" id="ff1" method="post" action="user_login">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="用户名 :" name="user.username" id="username" required>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="密码 :" name="user.password" id="email1" required>
                        </div>
                        <button type="submit" class="btn btn-1" name="login" id="login">登录</button>
                        <span>没有账户，<a href="/register.jsp">点此注册</a></span>
                    </form>
                </div>
                </c:if>
                <c:if test="${!empty sessionScope.user}">
                <div class="col-md-6">
                    <div class="heading"><h2>个人中心</h2></div>
                    <form name="form2" id="ff2" method="post" action="addressSet">
                        <div class="form-group">
                            <span>当前地址：${user.address}</span>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="输入新的地址信息 :" name="StringOfAddress" id="firstname" required>
                        </div>
                        <button type="submit" class="btn btn-1">提交更改</button>
                    </form>
                </div>
                </c:if>

            </div>
            <div id="sidebar" class="col-md-4">





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
                    Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
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

<!-- IMG-thumb -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
    $(document).ready(function(){
        $(".nav-tabs a").click(function(){
            $(this).tab('show');
        });
        $('.nav-tabs a').on('shown.bs.tab', function(event){
            var x = $(event.target).text();         // active tab
            var y = $(event.relatedTarget).text();  // previous tab
            $(".act span").text(x);
            $(".prev span").text(y);
        });
    });
</script>

<script>
    function changeCount()
    {
        var tempvar1 = parseInt(documentF.getElementById("inputcount").value);

        var tempvar = parseInt(document.getElementById("shoppingcount").innerHTML);
        // alert(tempvar1+tempvar);
        document.getElementById("shoppingcount").innerHTML=tempvar1+tempvar;
    }
    function init() {
        var myName="${message}";

        if(!myName.length==0){
            alert(myName);
        }

    }
</script>
</body>
</html>
