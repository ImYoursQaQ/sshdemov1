
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en" xmlns:c="http://www.w3.org/1999/html">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>手机销售网上商城后台管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor1/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor1/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="../vendor1/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist1/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor1/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
    <script type="text/javascript">
        function init() {
            var myName="${errorMessage}";

            if(!myName.length==0){
                alert(myName);
            }

        }

    </script>

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">手机销售网上商城后台管理</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <%--<li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->--%>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <%-- <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>--%>
                        <li class="divider"></li>
                        <li><a href="admin_logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <%--<li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>--%>


                        <li>
                            <a href="order_op"><i class="fa fa-table fa-fw"></i> 订单管理</a>
                        </li>
                        <li>
                            <a href="user_op"><i class="fa fa-table fa-fw"></i> 用户管理</a>
                        </li>

                        <li>
                            <a href=""><i class="fa fa-table fa-fw"></i> 手机商品管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="phone_op">查看全部</a>
                                </li>
                                <li>
                                    <a href="phone_op_to_add">增加手机</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>

                            <li>
                                <a href="poster_op"><i class="fa fa-table fa-fw"></i> 海报管理</a>
                            </li>


                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">新增手机</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            手机商品信息录入
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="col-lg-6">
                            <form role="form" action="phone_op_add" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>手机商品标题</label>
                                    <input class="form-control" name="goods.title">
                                </div>

                                <div class="form-group">
                                    <label>手机型号</label>
                                    <input class="form-control" name="goods.model">
                                </div>

                                <div class="form-group">
                                    <label>手机品牌</label>
                                    <select class="form-control" name="goods.brandid">
                                        <option value="101">苹果</option>
                                        <option value="102">三星</option>
                                        <option value="103">华为</option>
                                        <option value="104">小米</option>
                                        <option value="105">魅族</option>
                                        <option value="106">荣耀</option>
                                        <option value="107">一加</option>
                                        <option value="108">OPPO</option>
                                        <option value="109">vivo</option>
                                        <option value="110">其他</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>手机价格</label>
                                    <input class="form-control" name="goods.price">
                                </div>


                                <div class="form-group">
                                    <label >手机图片</label>
                                    <div class="">
                                        <img  id="img0" style="width: 100px;height: 100px" src="image/default.jpg">
                                        <input  class="" type="file" name="upload" id="file0" />
                                        <%--<span style='color:red' id="span_flie0"></span>--%>
                                    </div>
                                </div>



                                <div class="form-group">
                                    <label>上市时间</label>
                                    <input class="form-control" name="goods.timetomarket">
                                </div>

                                <div class="form-group">
                                    <label>网络制式</label>
                                    <input class="form-control" name="goods.networkmode">
                                </div>

                                <div class="form-group">
                                    <label>操作系统</label>
                                    <input class="form-control" name="goods.os">
                                </div>

                                <div class="form-group">
                                    <label>手机颜色</label>
                                    <select class="form-control" name="goods.colorid">
                                        <option value="101">金色</option>
                                        <option value="102">银色</option>
                                        <option value="103">玫瑰金</option>
                                        <option value="104">黑色</option>
                                        <option value="105">亮黑色</option>
                                        <option value="106">红色特别版</option>
                                        <option value="107">灰色</option>
                                        <option value="108">蓝色</option>
                                        <option value="109">粉色</option>
                                        <option value="110">其他</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>手机内存</label>
                                    <input class="form-control" name="goods.ram">
                                </div>

                                <div class="form-group">
                                    <label>手机存储</label>
                                    <select class="form-control" name="goods.romcapacityid">
                                        <option value="101">8GB</option>
                                        <option value="102">16GB</option>
                                        <option value="103">32GB</option>
                                        <option value="104">64GB</option>
                                        <option value="105">128GB</option>
                                        <option value="106">256GB</option>
                                        <option value="107">512GB</option>
                                        <option value="108">其他</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>手机尺寸</label>
                                    <input class="form-control" name="goods.size">
                                    <p class="help-block">Example:158.2*77.9*7.3</p>
                                </div>

                                <div class="form-group">
                                    <label>手机重量（克）</label>
                                    <input class="form-control" name="goods.weight">
                                </div>

                                <div class="form-group">
                                    <label>手机材质</label>
                                    <input class="form-control" name="goods.material">
                                </div>

                                <div class="form-group">
                                    <label>电池容量（mah）</label>
                                    <input class="form-control" name="goods.batterycapacity">
                                </div>

                                <div class="form-group">
                                    <label>屏幕大小（英寸）</label>
                                    <input class="form-control" name="goods.screensize">
                                </div>

                                <div class="form-group">
                                    <label>屏幕分辨率</label>
                                    <input class="form-control" name="goods.resolutionratio">
                                    <p class="help-block">Example:1920*1080(FHD)</p>
                                </div>

                                <div class="form-group">
                                    <label>屏幕像素密度（PPI）</label>
                                    <input class="form-control" name="goods.ppi">
                                </div>
                                <div class="form-group">
                                    <label>CPU信息</label>
                                    <input class="form-control" name="goods.cpumessage">
                                </div>

                                <div class="form-group">
                                    <label>GPU信息</label>
                                    <input class="form-control" name="goods.gpumessage">
                                </div>

                                <div class="form-group">
                                    <label>后置镜头</label>
                                    <input class="form-control" name="goods.pixelnumberofblack">
                                    <p class="help-block">Example:双1200万像素</p>
                                </div>

                                <div class="form-group">
                                    <label>后置镜头光圈</label>
                                    <input class="form-control" name="goods.aperture">
                                    <p class="help-block">Example:f/2.2</p>
                                </div>

                                <div class="form-group">
                                    <label>前置镜头</label>
                                    <input class="form-control" name="goods.pixelnumberoffront">
                                    <p class="help-block">Example:700万像素</p>
                                </div>

                                <div class="form-group">
                                    <label>特别功能</label>
                                    <input class="form-control" name="goods.function" value="不详">
                                </div>

                                <div class="form-group">
                                    <label>包装信息</label>
                                    <input class="form-control" name="goods.others" value="不详">
                                </div>

                                <div class="form-group">
                                    <label>其他</label>
                                    <input class="form-control" name="goods.packing" value="不详">
                                </div>


                                <button type="submit" class="btn btn-primary">提交</button>
                                <button type="reset" class="btn btn-warning">重置</button>
                            </form>
                            </div>
                            <!-- /.table-responsive -->

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor1/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor1/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor1/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../vendor1/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../vendor1/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../vendor1/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist1/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="js/bootstrap-fileinput.js"></script>
    <script type="text/javascript">
        $(function() {
            //比较简洁，细节可自行完善
            $('#uploadSubmit').click(function() {
                var data = new FormData($('#uploadForm')[0]);
                $.ajax({
                    url: 'xxx/xxx',
                    type: 'POST',
                    data: data,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function(data) {
                        console.log(data);
                        if (data.status) {
                            console.log('upload success');
                        } else {
                            console.log(data.message);
                        }
                    },
                    error: function(data) {
                        console.log(data.status);
                    }
                });
            });
        })
    </script>
    <script>
        //jquery上传图片前预览
        $("#file0").change(function(){
            var objUrl = getObjectURL(this.files[0]) ;
            console.log("objUrl = "+objUrl) ;
            if (objUrl) {
                $("#img0").attr("src", objUrl) ;
            }
        }) ;
        //建立一個可存取到該file的url
        function getObjectURL(file) {
            var url = null ;
            if (window.createObjectURL!=undefined) { // basic
                url = window.createObjectURL(file) ;
            } else if (window.URL!=undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file) ;
            } else if (window.webkitURL!=undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file) ;
            }
            return url ;
        }
    </script>

</body>

</html>
