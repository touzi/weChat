package com.touzi.wechat.login;  

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

/** 
 * @Title: LoginInterceptor.java 
 * @Package com.touzi.interceptor 
 * @Description: TODO(登录拦截器) 
 * @author touzi 
 * @date 2014年11月12日 下午3:06:09 
 * @version V1.0 
 */
public class LoginInterceptor implements Interceptor {

	public void intercept(ActionInvocation ai) {
		// TODO 验证session
		Controller controller = ai.getController();
		ai.getController().setAttr("url",ai.getActionKey());//什么地方拦截的,登陆后返回到什么地方---touzi
		if(controller.getSessionAttr("users") != null) {
			ai.invoke();
		}else {
			controller.setAttr("msg", "需要登录才能进行操作:)");
			controller.render("/_back/login/login.jsp");
		}
		
	}

}
  
