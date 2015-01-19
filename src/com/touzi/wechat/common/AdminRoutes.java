package com.touzi.wechat.common;

import com.jfinal.config.Routes;
import com.touzi.wechat.index.AdminIndexController;
import com.touzi.wechat.login.LoginController;

public class AdminRoutes extends Routes {

	public void config() {
		add("/admin",AdminIndexController.class,"/_back");
		add("/login", LoginController.class, "/_back/login");
		
	}
	
}
