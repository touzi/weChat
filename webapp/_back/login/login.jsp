<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<!-- <link href="/css/manage.css" media="screen" rel="stylesheet"type="text/css" /> -->
<!-- <script src="/js/jquery-1.4.4.min.js" type="text/javascript"></script> -->
<title>登录</title>
</head>
<body>
	<div class="manage_container">
<%-- 		<%@ include file="/common/_head.jsp"%> --%>
		<div class="main">
			<h1>用户管理---&gt;用户注册</h1>
			<div class="form_box">
				<form action="/login/inLogin" method="post">
					<fieldset class="solid">
						<legend>用户登录</legend>
						<input type="hidden" name="goto" value="${url}" />
						<div>
							<label>用户名</label>
							<input type="text" name="userName" value="${userName}" placeholder="用用户名来登录：)" />${userNameMsg}
						</div>
						<div>
							<label>密码</label>
							<input type="password" name="passWord" value="${passWord}" />${passWordMsg}
						</div>
						<div>
							<label>&nbsp;</label>${msg}
						</div>
						<div>
							<label>&nbsp;</label>
							<input value="提交" type="submit">
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>