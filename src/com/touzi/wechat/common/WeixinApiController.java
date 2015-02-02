package com.touzi.wechat.common;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MenuApi;
import com.jfinal.weixin.sdk.api.UserApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.touzi.wechat.model.PublicAccount;
import com.touzi.wechat.model.SysUser;

public class WeixinApiController extends ApiController {
	
	/**
	 * 路由过来之后用来处理管理后台的消息
	 * 
	 * 如果要支持多公众账号，只需要在此返回各个公众号对应的  ApiConfig 对象即可
	 * 可以通过在请求 url 中挂参数来动态从数据库中获取 ApiConfig 属性值
	 */
	public ApiConfig getApiConfig() {
		ApiConfig ac = new ApiConfig();
		SysUser su = this.getSessionAttr("users");
		PublicAccount pa = PublicAccount.me.findAllBySysUserId(su.getInt("id"));
		// 配置微信 API 相关常量
//		ac.setToken(PropKit.get("token"));
//		ac.setAppId(PropKit.get("appId"));
//		ac.setAppSecret(PropKit.get("appSecret"));
		ac.setToken(pa.getStr("token"));
		ac.setAppId(pa.getStr("app_id"));
		ac.setAppSecret(pa.getStr("app_secret"));
		
		/**
		 *  是否对消息进行加密，对应于微信平台的消息加解密方式：
		 *  1：true进行加密且必须配置 encodingAesKey
		 *  2：false采用明文模式，同时也支持混合模式
		 */
//		ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", false));
//		ac.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));
		if(null == pa.getStr("encoding_aes_key") || "".equals(pa.getStr("encoding_aes_key"))) {
			ac.setEncryptMessage(false);
			ac.setEncodingAesKey("setting it in config file");
		}else {
			ac.setEncryptMessage(true);
			ac.setEncodingAesKey(pa.getStr("encoding_aes_key"));
		}
		return ac;
	}
	
	/*
	public void index() {
		render("/api/index.html");
	}
	*/
	
	/**
	 * 获取公众号菜单
	 */
	public void getMenu() {
		ApiResult apiResult = MenuApi.getMenu();
		if (apiResult.isSucceed())
			renderText(apiResult.getJson());
		else
			renderText(apiResult.getErrorMsg());
	}
	
	/**
	 * 获取公众号关注用户
	 */
	public void getFollowers() {
		ApiResult apiResult = UserApi.getFollows();
		// TODO 用 jackson 解析结果出来
		renderText(apiResult.getJson());
	}
	
	public void getUserInfo() {
		String openId = getPara();
		ApiResult apiResult = UserApi.getUserInfo(openId);
		renderText(apiResult.getJson());
	}
}

