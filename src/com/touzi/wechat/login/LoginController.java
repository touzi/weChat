package com.touzi.wechat.login;  

import com.jfinal.core.Controller;
import com.touzi.log.Logs;
import com.touzi.wechat.model.SysUser;

/** 
 * @Title: LoginController.java 
 * @Package com.touzi.wechat.login 
 * @Description: TODO(登录系统) 
 * @author touzi 
 * @date 2015年1月15日 下午4:50:28 
 * @version V1.0 
 */
public class LoginController extends Controller {
	public void index() {
		String gotos = getPara("goto");
		if(gotos == null || ("").equals(gotos)) {
			gotos = "/_back/adminIndex.jsp";
		}
		/**
		 * 用户已经登录则执行哪里来到哪里去
		 */
		if(this.getSessionAttr("users") != null) {
			setAttr("msg", "已经登录:(");
			render(gotos);
		}else {
			render("login.jsp");
		}
	}
	
	public void inLogin() {
		String gotos = getPara("goto");
		/**
		 * 从哪里来到哪里去,否则回主页
		 */
		if(gotos == null || ("").equals(gotos)) {
			gotos = "/_back/adminIndex.jsp";
		}
		
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
  
