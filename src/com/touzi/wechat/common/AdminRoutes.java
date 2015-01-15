package com.touzi.wechat.common;

import com.jfinal.config.Routes;
import com.touzi.wechat.login.LoginController;

public class AdminRoutes extends Routes {

	public void config() {
		add("/login", LoginController.class, "/_back/login");
		
	}
	
}
