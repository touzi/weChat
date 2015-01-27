<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<fieldset class="solid">
	<legend>用户编辑</legend>
	<input type="hidden" name="sysUser.id" value="${sysUser.id}" />
	<input type="hidden" name="sysUser.in_time" value="${sysUser.in_time}" />
	<input type="hidden" name="sysUser.phone_no" value="${sysUser.phone_no}" />
	<input type="hidden" name="sysUser.score" value="${sysUser.score}" />
	<div>
		<label>用户名</label>
		<input type="text" name="sysUser.user_name" value="${sysUser.user_name}" />${userNameMsg}
	</div>
	<div>
		<label>密码</label>
		<input type="password" name="sysUser.pwd" value="${sysUser.pwd}" />${userPassWordMsg}
	</div>
	<div>
		<label>密码</label>
		<input type="password" name="rePassWord" value="" />${rePassWordMsg}
	</div>
<!-- 	<div> -->
<!-- 		<label>昵称</label> -->
<%-- 		<input type="text" name="sysUser.nickName" value="${sysUser.nickName }" />${nickNameMsg} --%>
<!-- 	</div> -->
	<div>
		<label>邮箱</label>
		<input type="text" name="sysUser.email" value="${sysUser.email }" />${registerEmailMsg}
	</div>
<!-- 	<div> -->
<!-- 		<label>状态</label> -->
<!-- 		<select name="sysUser.isValid"> -->
<!-- 			<option value="1">启用</option> -->
<!-- 			<option value="0">停用</option> -->
<%-- 		</select>	${sysUserEnabledMsg} --%>
<!-- 	</div> -->
<!-- 	<div> -->
<!-- 		<label>关于</label> -->
<%-- 		<textarea name="sysUser.sysUserInfo" cols="80" rows="10">${sysUser.sysUserInfo}</textarea>${sysUserInfoMsg} --%>
<!-- 	</div> -->
	<div>
		<label>&nbsp;</label>
		<input value="提交" type="submit">
	</div>
</fieldset>