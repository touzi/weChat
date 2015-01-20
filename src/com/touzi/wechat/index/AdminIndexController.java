package com.touzi.wechat.index;  

import com.jfinal.core.Controller;
import com.touzi.wechat.model.PublicAccount;
import com.touzi.wechat.model.SysUser;

/** 
 * @Title: AdminIndexController.java 
 * @Package com.touzi.wechat.index 
 * @Description: TODO(后端首页) 
 * @author touzi 
 * @date 2015年1月16日 下午2:29:21 
 * @version V1.0 
 */
public class AdminIndexController extends Controller {
	public void index() {
		SysUser su = this.getSessionAttr("users");
		setAttr("publicAccount", PublicAccount.me.findAllBySysUserId(su.getInt("id")));
		render("adminIndex.jsp");
	}
	
//	public List<PublicAccount> publicAccountInfo() {
//		PublicAccount pa = getModel(PublicAccount.class);
//		SysUser su = this.getSessionAttr("users");
//		System.out.println("根据id查pa->"+su.getInt("sysUserId"));
//		return pa.findAllBySysUserId(su.getInt("sysUserId"));
//	}
}
  
