package com.touzi.wechat.common;  

import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.TemplateMsgApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.touzi.wechat.model.PublicAccount;

/** 
 * @Title: TemplateMsgApiController.java 
 * @Package com.touzi.wechat.common 
 * @Description: TODO(开放给第三方系统调用) 
 * @author touzi 
 * @date 2015年1月30日 下午2:23:33 
 * @version V1.0 
 */
@ClearInterceptor(ClearLayer.ALL)
public class OpenApiController extends ApiController {
	public ApiConfig getApiConfig() {
		ApiConfig ac = new ApiConfig();
		PublicAccount pa = PublicAccount.me.findByweChat(getPara());
		if (pa != null) {
			// 配置微信 API 相关常量
			ac.setToken(pa.getStr("token"));
			ac.setAppId(pa.getStr("app_id"));
			ac.setAppSecret(pa.getStr("app_secret"));
			
			/**
			 *  是否对消息进行加密，对应于微信平台的消息加解密方式：
			 *  1：true进行加密且必须配置 encodingAesKey
			 *  2：false采用明文模式，同时也支持混合模式
			 */
			if(null == pa.getStr("encoding_aes_key") || "".equals(pa.getStr("encoding_aes_key"))) {
				ac.setEncryptMessage(false);
				ac.setEncodingAesKey("setting it in config file");
			}else {
				ac.setEncryptMessage(true);
				ac.setEncodingAesKey(pa.getStr("encoding_aes_key"));
			}
		}
		return ac;
	}
	
	/**
	 * @author touzi
	 * @dateTime 2015年1月30日上午11:26:07
	 * @Title: sendTemplateMsg 
	 * @Description: TODO(发送模版消息) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void sendTemplateMsg() {
		String jsonStr = getPara("data");
		System.out.println("=>"+jsonStr);
		if(jsonStr != null && !"".equals(jsonStr)){
			ApiResult apiResult = TemplateMsgApi.sendTemplateMsg(jsonStr);
			if (apiResult.isSucceed())
				renderText(apiResult.getJson());
			else
				renderText(apiResult.getErrorMsg());
		}else {
			renderText("Value is blank or null.");
		}
	}
	
	
	public void getUserToFrom() {
		
	}
}
  
