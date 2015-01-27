<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<!-- 兼容手机端 -->
<meta name = "viewpoint" content = "width-device-width, intial-scale=1.0">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link href="/css/signin.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery-1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link rel="stylesheet" href="/css/dashboard.css">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<script src="/js/ie-emulation-modes-warning.js"></script>
<!-- 跳转提示 -->
<script src="/js/utils.js"></script>
<title>登录</title>
</head>
<body>
	<div class="container">
		<div>
			<label>&nbsp;</label>${msg}
		</div>
      <form class="form-signin" role="form" action="/login/inLogin" method="post">
      	<input type="hidden" name="goto" value="${url}" />
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" 
        	name="userName" value="${userName}" placeholder="仅支持用户名：)" required autofocus/>${userNameMsg}
        <input type="password" class="form-control" placeholder="密码" 
        	name="passWord" value="${passWord}" required>${passWordMsg}
<!--         <div class="checkbox"> -->
<!--           <label> -->
<!--             <input type="checkbox" value="remember-me"> Remember me -->
<!--           </label> -->
<!--         </div> -->
        <button class="btn btn-lg btn-primary btn-block" type="submit" 
        onclick="showdiv('正在登录中<br/>请稍候........ <br/> ');">Sign in</button>
      </form>
    </div>
</body>
</html>