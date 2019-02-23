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
                    <li><a href="">${brand.brandname}</a></li>
                    <li><a href="">${goods.title}</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div id="main-content" class="col-md-12">
                <div class="product">
                    <div class="col-md-6">
                        <div class="image">
                            <img src="${goods.mainpic}" width="540" height="540"/>

                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="caption">
                            <div class="name"><h3>${goods.title} </h3></div>
                            <div class="info">
                                <ul>
                                    <li>颜色: ${phonecolor.colorname}</li>
                                    <li>版本: ${rom.roMcapacityname}</li>
                                </ul>
                            </div>
                            <div class="price">${goods.price}<span>￥6888</span></div>

                            <div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
                            <div class="well"><label>数量: </label>
                                <form action="addCart?goodsid=${goods.goodsid}&userid=${user.userid}" method="post">
                                    <input id="inputcount" name="inputcount" class="form-inline quantity" type="text" value="1">
                                    <input type="submit"  class="btn btn-2 " value="加入购物车">
                                    <%--<a href="" class="btn btn-2 " onclick="changeCount()">加入购物车</a>--%>
                                    </input>
                                </form>
                            </div>

                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="product-desc">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#description">详细参数</a></li>
                        <li><a href="#review">评论</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="description" class="tab-pane fade in active">
                            <h4>基本</h4>
                            <table>
                                <tr>
                                    <td name="td1">品牌</td>
                                    <td>${brand.brandname}</td>
                                </tr>
                                <tr>
                                    <td name="td1">型号</td>
                                    <td>${goods.model}</td>
                                </tr>
                                <tr>
                                    <td name="td1">上市日期</td>
                                    <td>${goods.timetomarket}</td>
                                </tr>
                                <tr>
                                    <td name="td1">网络制式</td>
                                    <td>${goods.networkmode}</td>
                                </tr>
                                <tr>
                                    <td name="td1">操作系统</td>
                                    <td>${goods.os}</td>
                                </tr>
                            </table>
                            <h4>外观</h4>
                            <table>
                                <tr>
                                    <td name="td1">颜色</td>
                                    <td>${phonecolor.colorname}</td>
                                </tr>
                                <tr>
                                    <td name="td1">尺寸</td>
                                    <td>${goods.size}</td>
                                </tr>
                                <tr>
                                    <td name="td1">重量</td>
                                    <td>${goods.weight}</td>
                                </tr>
                                <tr>
                                    <td name="td1">材质</td>
                                    <td>${goods.material}</td>
                                </tr>
                            </table>
                            <h4>硬件</h4>
                            <table>
                                <tr>
                                    <td>CPU</td>
                                    <td>${goods.cpumessage}</td>
                                </tr>
                                <tr>
                                    <td>GPU</td>
                                    <td>${goods.gpumessage}</td>
                                </tr>
                                <tr>
                                    <td>内存RAM</td>
                                    <td>${goods.ram}</td>
                                </tr>
                                <tr>
                                    <td>容量ROM</td>
                                    <td>${rom.roMcapacityname}</td>
                                </tr>
                                <tr>
                                    <td>电池容量</td>
                                    <td>${goods.batterycapacity}</td>
                                </tr>
                            </table>
                            <h4>屏幕</h4>
                            <table>
                                <tr>
                                    <td>屏幕尺寸</td>
                                    <td>${goods.screensize}</td>
                                </tr>
                                <tr>
                                    <td>分辨率</td>
                                    <td>${goods.resolutionratio}</td>
                                </tr>
                                <tr>
                                    <td>PPI</td>
                                    <td>${goods.ppi}</td>
                                </tr>
                            </table>
                            <h4>拍照</h4>
                            <table>
                                <tr>
                                    <td>前置</td>
                                    <td>${goods.pixelnumberoffront}</td>
                                </tr>
                                <tr>
                                    <td>后置</td>
                                    <td>${goods.pixelnumberofblack}</td>
                                </tr>
                                <tr>
                                    <td>光圈</td>
                                    <td>${goods.aperture}</td>
                                </tr>
                            </table>
                            <h4>其他</h4>
                            <table>
                                <tr>
                                    <td>功能</td>
                                    <td>${goods.function}</td>
                                </tr>
                                <tr>
                                    <td>特点</td>
                                    <td>${goods.others}</td>
                                </tr>
                                <tr>
                                    <td>包装</td>
                                    <td>${goods.packing}</td>
                                </tr>
                            </table>
                            </div>
                        <div id="review" class="tab-pane fade">
                            <div class="review-text">
                                <%--评论区--%>
                                    <c:if test="${empty tReviewList}">
                                        <span style="text-align:center"><h2>没有评论！</h2></span>

                                    </c:if>
                                    <c:if  test="${!empty tReviewList}">
                                        <c:forEach items="${tReviewList}" var="Reviewentry" varStatus="status">
                                            <%--<div style="border: 1px solid;width:600px;">
                                                <table class="table" style="margin-left: 0px;" border="0">
                                                    <tr>
                                                        <td>${Reviewentry.username}</td>
                                                        <td>${Reviewentry.reviewTime}</td>
                                                        <td>${Reviewentry.userforgoodsScore}</td>

                                                    </tr>
                                                    <tr >
                                                        <td colspan="3">
                                                            <p>${Reviewentry.userreviewtext}</p>
                                                        </td>
                                                    </tr>


                                                </table>

                                            </div>--%>
                                            <div class="row" style="height: 100px;margin-bottom: 5px;">
                                                <div class="product well" style="margin-top: 30px;">

                                                    <div class="col-md-8">

                                                        <div class="caption">
                                                            <div class="name">
                                                                <span>${Reviewentry.username}</span>
                                                                <span>${Reviewentry.reviewTime}</span>
                                                                <span>评分：${Reviewentry.userforgoodsScore}</span>
                                                            </div>


                                                            <div><span><p style="margin-bottom: 0px;">${Reviewentry.userreviewtext}</p></span>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>


                                        </c:forEach>
                                    </c:if>
                            </div>
                        <c:if test="${!empty user}">
                            <div class="review-form" style="margin-top: 30px;">
                                <h4>评分及评论</h4>
                                <form name="form1" method="post" action="review_submit?goodsid=${goods.goodsid}">
                                    <label>
                                        <span>输入您的评分:</span>
                                        <input type="number" step="0.01" min="0" max="10"  name="userreview.userforgoodsScore" id="score1" required/>
                                    </label>
                                    <label>
                                        <span>输入您的评论:</span>
                                        <textarea name="userreview.userreviewtext" id="message" required></textarea>
                                    </label>
                                    <div class="text-right">
                                        <input class="btn btn-default" type="reset" name="reset" value="重置">
                                        <input class="btn btn-default" type="submit" name="Submit" value="提交评论">
                                    </div>
                                </form>
                            </div>
                        </c:if>
                        </div>
                    </div>
                </div>

            </div>
            <div id="sidebar" class="col-md-4">





            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>