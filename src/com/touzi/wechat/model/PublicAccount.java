package com.touzi.wechat.model;  

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.touzi.tools.OtherTools;

/** 
 * @Title: PublicAccount.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(公众号model) 
 * @author touzi 
 * @date 2015年1月15日 下午3:49:14 
 * @version V1.0 
 * mysql> describe wechat_public_account;
+------------------+--------------+------+-----+---------+----------------+
| Field            | Type         | Null | Key | Default | Extra          |
+------------------+--------------+------+-----+---------+----------------+
| id               | int(11)      | NO   | PRI | NULL    | auto_increment |主键id,自增
| account_id       | varchar(255) | YES  |     | NULL    |                |授权id,通过接口授权后产生
| app_id           | varchar(255) | YES  |     | NULL    |                |应用id,对应微信后台产生的,需填写
| app_secret       | varchar(255) | YES  |     | NULL    |                |应用密钥,对应微信后台产生的,需填写
| in_time          | datetime     | YES  |     | NULL    |                |绑定时间
| pwd              | varchar(255) | YES  |     | NULL    |                |
| ticket           | varchar(255) | YES  |     | NULL    |                |二维码信息
| token            | varchar(255) | YES  |     | NULL    |                |令牌,需要与公众号后台同意,这里有系统生成,然后填写到微信后台
| update_time      | datetime     | YES  |     | NULL    |                |更新时间
| url              | varchar(255) | YES  |     | NULL    |                |本地接口URL,带参数以便区分不同的用户的帐号
| url_para         | varchar(255) | YES  |     | NULL    |                |本地接口URL的参数,以便区分不同的用户的帐号
| user_name        | varchar(255) | YES  |     | NULL    |                |公众号名称
| valid_code       | varchar(255) | YES  |     | NULL    |                |验证码,用户匹配管理员的微信id
| valid_state      | varchar(255) | YES  |     | NULL    |                |对接步骤
| sys_user_id      | int(11)      | NO   |     | NULL    |                |系统管理员id
| encoding_aes_key | varchar(255) | YES  |     | NULL    |                |消息加密密钥
+------------------+--------------+------+-----+---------+----------------+
 */
@SuppressWarnings("serial")
public class PublicAccount extends Model<PublicAccount> {
	public static final PublicAccount me = new PublicAccount();
	
	/**
	 * 1. 用户注册后产生token,url,validCode
	 * 2. 填入sysUserId
	 */
	public void mySave(Integer suId,String userName) {
		String token = OtherTools.getMD5(userName.getBytes());
		String urlPara = OtherTools.getMD5(token.getBytes());
		String url = "http://localhost/msg/"+urlPara;
		String validCode = OtherTools.getRandom(4);
		String ticket = OtherTools.getMD5(new Date().toString().getBytes());
		this.set("sys_user_id",suId).set("token",token).set("url",url).set("url_para",urlPara).set("valid_code",validCode).set("ticket",ticket).set("valid_state","1");
		this.save();
	}
	
	/**
	 * 根据用户id查询,公众号信息
	 */
	public PublicAccount findAllBySysUserId(Integer sysUserId) {
		List<PublicAccount> result = find("select * from wechat_public_account where sys_user_id = "+sysUserId);
		return result.size() > 0 ? result.get(0) : null;
	}
	
	/**
	 * 根据微信回传的URL与参数查询数据库
	 */
	public PublicAccount findByweChat(String urlValue) {
		String sql = "select * from wechat_public_account where url_para = '"+urlValue+"'";
		List<PublicAccount> result = find(sql);
		return result.size() > 0 ? result.get(0) : null;
	}
	
	/**
	 * 生成授权(根据id更新appId,应用密钥,消息加解密密钥)
	 */
	public void myUpdate() {
		if(null == this.getTimestamp("in_time") || "".equals(this.getTimestamp("in_time"))){
			this.set("in_time", new Date());
		}else {
			this.set("update_time", new Date());
		}
		this.update();
	}
	
	/**
	 * 授权成功更新AccountId
	 */
	public void accUpdate(PublicAccount pa, String toUserName) {
		this.set("id",pa.getInt("id")).set("account_id",toUserName).set("update_time", new Date());
		this.update();
	}
}
  
