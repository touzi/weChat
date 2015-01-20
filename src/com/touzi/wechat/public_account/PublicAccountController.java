package com.touzi.wechat.public_account;  

import com.jfinal.core.Controller;
import com.touzi.wechat.model.PublicAccount;

/** 
 * @Title: PublicAccountController.java 
 * @Package com.touzi.wechat.public_account 
 * @Description: TODO(
 * 1. 公众号授权
 * 2. 公众号设置
 * ) 
 * @author touzi 
 * @date 2015年1月20日 下午1:38:36 
 * @version V1.0 
 */
public class PublicAccountController extends Controller {
	public void index() {
		redirect("/admin");
	}
	
	
	/**
	 * 生成授权信息
	 */
	public void update() {
		PublicAccount publicAccount = getModel(PublicAccount.class);
		publicAccount.myUpdate();
		redirect("/admin");
	}
}
  