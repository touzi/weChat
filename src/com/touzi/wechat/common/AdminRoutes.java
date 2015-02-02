package com.touzi.wechat.common;

import com.jfinal.config.Routes;
import com.touzi.wechat.index.AdminIndexController;
import com.touzi.wechat.login.LoginController;
import com.touzi.wechat.material.MaterialController;
import com.touzi.wechat.public_account.PublicAccountController;

public class AdminRoutes extends Routes {

	public void config() {
		add("/admin",AdminIndexController.class,"/_back");
		add("/login", LoginController.class, "/_back/login");
		add("/publicAccount",PublicAccountController.class,"/_back/publicAccount");
		add("/material",MaterialController.class,"/_back/material");
		add("/openApi",OpenApiController.class,"/openApi");
	}
	
}
