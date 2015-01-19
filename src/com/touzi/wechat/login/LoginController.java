package com.touzi.wechat.login;  

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.core.Controller;
import com.touzi.log.Logs;
import com.touzi.wechat.model.PublicAccount;
import com.touzi.wechat.model.SysUser;
import com.touzi.wechat.model.UserInfo;

/** 
 * @Title: LoginController.java 
 * @Package com.touzi.wechat.login 
 * @Description: TODO(登录系统) 
 * @author touzi 
 * @date 2015年1月15日 下午4:50:28 
 * @version V1.0 
 */
@ClearInterceptor
public class LoginController extends Controller {
	public void index() {
		String gotos = getPara("goto");
		if(gotos == null || ("").equals(gotos)) {
			gotos = "/admin";
		}
		/**
		 * 用户已经登录则执行哪里来到哪里去
		 */
		if(this.getSessionAttr("users") != null) {
			setAttr("msg", "已经登录:(");
			redirect(gotos);
		}else {
			render("login.jsp");
		}
	}
	
	/**
	 * 登录
	 */
	public void inLogin() {
		String gotos = getPara("goto");
		/**
		 * 从哪里来到哪里去,否则回主页
		 */
		if(gotos == null || ("").equals(gotos)) {
			gotos = "/admin";
		}
		
		/**
		 * 用户已经登录则执行哪里来到哪里去
		 */
		if(this.getSessionAttr("users") != null) {
			setAttr("msg", "已经登录:(");
			redirect(gotos);
		}else {
			String userName = getPara("userName");
			String passWord = getPara("passWord");
			SysUser user = SysUser.me.getUserNameAndPassWord(userName, passWord);
			if(user != null) {
				//String userInfo = user.getStr("id") +","+user.getStr("userName");//需要什么都可以继续存储		---touzi
				//setCookie("userInfo", userInfo, 3600*24*30);
				setSessionAttr("users", user);
				redirect(gotos);
				Logs.logInfo(this.getSessionAttr("users"), getRequest(), "用户登录");
			}else {
				setAttr("userName", userName);
				setAttr("passWord", passWord);
				setAttr("msg", "用户名或密码错误:(");
				render("login.jsp");
				Logs.logInfo(this.getSessionAttr("users"), getRequest(), userName+"->登录失败");
			}
		}
	}
	
	/**
	 * 注册
	 */
	public void register() {
		render("/_back/login/register.jsp");
	}
	
	/**
	 * 注册用户表单保存
	 */
	@Before(SysUserValidator.class)
	public void save() {
		SysUser sysUser = getModel(SysUser.class);
		UserInfo userInfo = getModel(UserInfo.class);
		PublicAccount publicAccount = getModel(PublicAccount.class);
		sysUser.mySave();
		publicAccount.mySave(sysUser.getInt("id"),sysUser.getStr("userName"));
		userInfo.mySave(sysUser.getInt("id"),publicAccount.getInt("id"));//同时写入userinfo表
		Logs.logInfo(this.getSessionAttr("users"), getRequest(), "注册新用户->"+sysUser.getInt("id"));
		setAttr("msg", "注册成功,请登录!");
		render("/_back/login/login.jsp");
	}
}
  
