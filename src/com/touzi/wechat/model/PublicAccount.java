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
 * mysql> describe wechatPublicAccount;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| id             | int(11)      | NO   | PRI | NULL    | auto_increment |主键id,自增
| accountId      | varchar(255) | YES  |     | NULL    |                |授权id,通过接口授权后产生
| appId          | varchar(255) | YES  |     | NULL    |                |应用id,对应微信后台产生的,需填写
| appSecret      | varchar(255) | YES  |     | NULL    |                |应用密钥,对应微信后台产生的,需填写
| inTime         | datetime     | YES  |     | NULL    |                |绑定时间
| pwd            | varchar(255) | YES  |     | NULL    |                |
| ticket         | varchar(255) | YES  | UNI | NULL    |                |二维码信息
| token          | varchar(255) | YES  |     | NULL    |                |令牌,需要与公众号后台同意,这里有系统生成,然后填写到微信后台
| updateTime     | datetime     | YES  |     | NULL    |                |更新时间
| url            | varchar(255) | YES  |     | NULL    |                |本地接口URL,带参数以便区分不同的用户的帐号
| urlPara        | varchar(255) | YES  |     | NULL    |                |本地接口URL的参数,以便区分不同的用户的帐号
| userName       | varchar(255) | YES  |     | NULL    |                |公众号名称
| validCode      | varchar(255) | YES  |     | NULL    |                |验证码,用户匹配管理员的微信id
| validState     | varchar(255) | YES  |     | NULL    |                |对接步骤
| sysUserId      | int(11)      | YES  | MUL | NULL    |                |系统管理员id
| encodingAESKey | varchar(255) | YES  |     | NULL    |                |消息加密密钥
+----------------+--------------+------+-----+---------+----------------+
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
		this.set("sysUserId",suId).set("token",token).set("url",url).set("urlPara",urlPara).set("validCode",validCode).set("ticket",ticket).set("validState","1");
		this.save();
	}
	
	/**
	 * 根据用户id查询,公众号信息
	 */
	public PublicAccount findAllBySysUserId(Integer sysUserId) {
		List<PublicAccount> result = find("select * from wechatPublicAccount where sysUserId = "+sysUserId);
		return result.size() > 0 ? result.get(0) : null;
	}
	
	/**
	 * 根据微信回传的URL与参数查询数据库
	 */
	public PublicAccount findByweChat(String urlValue) {
		String sql = "select * from wechatPublicAccount where urlPara = '"+urlValue+"'";
		List<PublicAccount> result = find(sql);
		return result.size() > 0 ? result.get(0) : null;
	}
	
	/**
	 * 生成授权(根据id更新appId,应用密钥,消息加解密密钥)
	 */
	public void myUpdate() {
		if(null == this.getTimestamp("inTime") || "".equals(this.getTimestamp("inTime"))){
			this.set("inTime", new Date());
		}else {
			this.set("updateTime", new Date());
		}
		this.update();
	}
	
	/**
	 * 授权成功更新AccountId
	 */
	public void accUpdate(PublicAccount pa, String toUserName) {
		this.set("id",pa.getInt("id")).set("accountId",toUserName).set("updateTime", new Date());
		this.update();
	}
}
  
