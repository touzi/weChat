package com.touzi.wechat.model;  

import com.jfinal.plugin.activerecord.Model;

/** 
 * @Title: UserInfo.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(用户信息及关注者) 
 * @author touzi 
 * @date 2015年1月15日 下午4:12:53 
 * @version V1.0 
 * mysql> describe wechatUserInfo;
+-----------------+--------------+------+-----+---------+----------------+
| Field           | Type         | Null | Key | Default | Extra          |
+-----------------+--------------+------+-----+---------+----------------+
| id              | int(11)      | NO   | PRI | NULL    | auto_increment |
| sysUserId       | int(11)      | YES  |     | NULL    |                |对应用户表id
| city            | varchar(255) | YES  |     | NULL    |                |城市
| country         | varchar(255) | YES  |     | NULL    |                |国家
| headimgUrl      | varchar(255) | YES  |     | NULL    |                |标题URL
| language        | varchar(255) | YES  |     | NULL    |                |语言
| nickName        | varchar(255) | YES  |     | NULL    |                |昵称
| openId          | varchar(255) | YES  |     | NULL    |                |微信openid(用户的)
| province        | varchar(255) | YES  |     | NULL    |                |微信带过来的用户信息地区
| sex             | varchar(255) | YES  |     | NULL    |                |性别
| subscribe       | varchar(255) | YES  |     | NULL    |                |是否订阅
| subscribeTime   | datetime     | YES  |     | NULL    |                |订阅时间
| unsubscribeTime | datetime     | YES  |     | NULL    |                |取消订阅时间
| publicAccountId | int(11)      | NO   | MUL | NULL    |                |对应表publicaccountid
| wechatOpenId    | varchar(255) | YES  |     | NULL    |                |公众号原始id(可以要求管理员填写)
| groupId         | varchar(32)  | YES  | MUL | NULL    |                |系统所在的组
+-----------------+--------------+------+-----+---------+----------------+
16 rows in set
 */
@SuppressWarnings("serial")
public class UserInfo extends Model<UserInfo> {
	public static final UserInfo me = new UserInfo();
	
	/**
	 * 注册用户的同时生成用户信息表记录
	 * groupId注册时分配到guest,如果修改验证了公众号则改成管理员
	 */
	public void mySave(Integer suId,Integer paId) {
		this.set("sysUserId",suId).set("groupId",2).set("publicAccountId",paId);
		this.save();
	}
}
  
