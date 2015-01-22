<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配置授权</title>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">配置授权</h1>
		<div class="alert alert-info">
			<p>
				在微信公众平台<strong>“功能”</strong>-&gt;<strong>“高级功能”</strong>-&gt;<strong>“开发模式”，</strong>将<strong>AppId和AppSecret</strong>，然后填入下边表单。
			</p>
			<p>通过认证的订阅号，拥有“自定义菜单”；通过认证的服务号，拥有“自定义菜单”和所有“高级接口”</p>
			<p>
				<strong>配置步骤：</strong>
			</p>
			<p id="step1">
				1、<span class="step-info">将授权信息配置到公众平台&nbsp;<a
					href="javascript:void(-1);"><span
						class="glyphicon glyphicon-question-sign"></span></a></span>
			</p>
			<p id="step2">
				2、<span class="step-info">从微信客户端向公众号发送：${publicAccount.validCode }&nbsp;<a
					href="javascript:void(-1);"><span
						class="glyphicon glyphicon-question-sign"></span></a></span>
			</p>
			<p id="step3">
				3、<span class="step-info">完成授权</span>
			</p>
		</div>
		<form class="form-horizontal" id="form-auth" action="/publicAccount/update" method="POST">
			<input type="hidden" name="publicAccount.id" value="${publicAccount.id }" />
			<input type="hidden" name="publicAccount.validState" value="2" />
			<input type="hidden" name="publicAccount.inTime" value="${publicAccount.inTime }" />
			<input type="hidden" name="publicAccount.validCode" value="${publicAccount.validCode}" />
			<input type="hidden" name="publicAccount.sysUserId" value="${publicAccount.sysUserId}" />
			<div class="form-group">
				<label class="col-sm-2 control-label" for="url">URL:</label>
				<div class="col-sm-5">
					<input readonly="readonly" type="text" class="span4 form-control"
						id="url" name="publicAccount.url" value="${publicAccount.url }"> 
				</div>
				<span class="col-sm-5 text-primary">复制到公众平台<strong>“开发者中心”</strong>-><strong>“服务器配置”</strong>-><strong>“URL”</strong></span>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="token">TOKEN:</label>
				<div class="col-sm-5">
					<input readonly="readonly" type="text" class="span4 form-control"
						id="token" name="publicAccount.token" value="${publicAccount.token }">
				</div>
				 <span class="col-sm-5 text-primary">复制到公众平台<strong>“开发者中心”</strong>-><strong>“服务器配置”</strong>-><strong>“TOKEN”</strong></span>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="app_id">AppId:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="app_id"
						name="publicAccount.appId" value="${publicAccount.appId }"> 
				</div>
				<div>
					<span class="col-sm-5 text-primary">未认证的订阅号可留空</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="app_secret">应用密钥:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="app_secret" name="publicAccount.appSecret" value="${publicAccount.appSecret }"> 
				</div>
				<span class="col-sm-5 text-primary">未认证的订阅号可留空</span>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="app_secret">消息加解密密钥:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="app_secret" name="publicAccount.encodingAESKey" value="${publicAccount.encodingAESKey }">
				</div>
				<span class="col-sm-5 text-primary">未启用消息加密可留空</span>
			</div>
			<br/>
			<c:choose>
				<c:when
					test="${ 1 == publicAccount.validState || '1' eq publicAccount.validState }">
					<input style="margin-left: 180px;" class="btn btn-danger"
						type="submit" id="btn-submit"data-loading-text="Loading..." autocomplete="off"
						value="&nbsp;生&nbsp;成&nbsp;授&nbsp;权&nbsp;" />
				</c:when>
				<c:otherwise>
					<input style="margin-left: 180px;" class="btn btn-primary" type="submit" 
						id="btn-submit"  data-loading-text="Loading..." autocomplete="off"
						value="&nbsp;更&nbsp;新&nbsp;授&nbsp;权&nbsp;" />
				</c:otherwise>
			</c:choose>
		</form>
	</div>
<jsp:include page="/_back/common/headAndLeft.jsp"></jsp:include>
</body>
</html>