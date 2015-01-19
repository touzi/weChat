package com.touzi.wechat.index;


import org.apache.log4j.Logger;

import com.jfinal.aop.ClearInterceptor;
import com.jfinal.core.Controller;


/**
 * IndexController
 */

@ClearInterceptor
public class IndexController extends Controller {
	
	private static Logger log = Logger.getLogger(IndexController.class);
	public void index() {
		log.warn("进入首页!");
		render("index.html");
	}
}





