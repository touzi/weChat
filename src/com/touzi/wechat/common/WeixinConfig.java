/**
 * Copyright (c) 2011-2014, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.touzi.wechat.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.touzi.log.Logs;
import com.touzi.wechat.login.LoginInterceptor;
import com.touzi.wechat.model.Material;
import com.touzi.wechat.model.PublicAccount;
import com.touzi.wechat.model.ReqMsgLog;
import com.touzi.wechat.model.SysUser;
import com.touzi.wechat.model.UserInfo;

public class WeixinConfig extends JFinalConfig {
	
	/**
	 * 如果生产环境配置文件存在，则优先加载该配置，否则加载开发环境配置文件
	 * @param pro 生产环境配置文件
	 * @param dev 开发环境配置文件
	 */
	public void loadProp(String pro, String dev) {
		try {
			PropKit.use(pro);
		}
		catch (Exception e) {
			PropKit.use(dev);
		}
	}
	
	public void configConstant(Constants me) {
		loadProp("a_little_config_pro.txt", "a_little_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setViewType(ViewType.JSP);
		
		// ApiConfigKit 设为开发模式可以在开发阶段输出请求交互的 xml 与 json 数据
		ApiConfigKit.setDevMode(me.getDevMode());
		//设置404跳转页面
		me.setError404View("/_front/common/404.html");
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add(new FrontRoutes());	//端端路由
		me.add(new AdminRoutes());	//后端路由
		me.add("/msg", WeixinMsgController.class);
		me.add("/api", WeixinApiController.class, "/api");
	}
	
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		 C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		 me.add(c3p0Plugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
//		 EhCachePlugin ecp = new EhCachePlugin();
//		 me.add(ecp);
		arp.addMapping("wechat_sys_user", SysUser.class);//映射wechat_sys_user表到SysUser模型(映射名字必须与数据库表名一致)
		arp.addMapping("wechat_sys_log", Logs.class);
		arp.addMapping("wechat_user_info", UserInfo.class);
		arp.addMapping("wechat_public_account", PublicAccount.class);
		arp.addMapping("wechat_req_msg_log", ReqMsgLog.class);
		arp.addMapping("wechat_material", Material.class);
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		//登录拦截器
		me.add(new LoginInterceptor());
		
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		
	}
	
	public static void main(String[] args) {
		JFinal.start("webapp", 83, "/", 5);
	}
}
