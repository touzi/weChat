<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 兼容手机端 -->
<meta name = "viewpoint" content = "width-device-width, intial-scale=1.0">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
<!-- Custom styles for this template 框架css,可以把一般css写到其中 -->
<link rel="stylesheet" href="/css/dashboard.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery-1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap/bootstrap.min.js"></script>
<!-- Just for debugging purposes. Don't actually copy these 2 lines! 兼容ie -->
<script src="/js/bootstrap/ie-emulation-modes-warning.js"></script>
<!-- 跳转提示 -->
<script src="/js/utils.js"></script>
<title>weChatDevloper</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="">weChatDevloper</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="/login/logout">Logout</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" id="menu">
          <ul class="nav nav-sidebar">
          	<li class="menu_title" >
          	<i class="icon_menu" style="background:url(/img/icon_menu_function.png) no-repeat;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>
          	功能
          	</li>
<!--           	 class="active"  -->
            <li><a href="/publicAccount">配置授权</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
          	<li class="menu_title" >
          	<i class="icon_menu" style="background:url(/img/icon_menu_management.png) no-repeat;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>
          	管理
          	</li>
          	<li><a href="/material" >素材管理</a></li>
            <li><a href="#">Nav item again</a></li>
            <li><a href="#">One more nav</a></li>
            <li><a href="#">Another nav item</a></li>
          </ul>
          <ul class="nav nav-sidebar">
          	<li class="menu_title" >
          	<i class="icon_menu" style="background:url(/img/icon_menu_setup.png) no-repeat;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>
          	统计
          	</li>
            <li><a href="#">Nav item again</a></li>
            <li><a href="#">One more nav</a></li>
            <li><a href="#">Another nav item</a></li>
          </ul>
        </div>
      </div>
    </div>
</body>
</html>
<script language="javascript">

</script>