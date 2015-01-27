package com.touzi.wechat.model;  

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;

/** 
 * @Title: UserInfo.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(用户信息及关注者) 
 * @author touzi 
 * @date 2015年1月15日 下午4:12:53 
 * @version V1.0 
 * mysql> describe wechat_user_info;
+-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| id                | int(11)      | NO   | PRI | NULL    | auto_increment |
| sys_user_id       | int(11)      | YES  |     | NULL    |                |对应用户表id
| city              | varchar(255) | YES  |     | NULL    |                |城市
| country           | varchar(255) | YES  |     | NULL    |                |国家
| headimg_url       | varchar(255) | YES  |     | NULL    |                |标题URL
| language          | varchar(255) | YES  |     | NULL    |                |语言
| nick_name         | varchar(255) | YES  |     | NULL    |                |昵称
| open_id           | varchar(255) | YES  |     | NULL    |                |微信openid(用户的)
| province          | varchar(255) | YES  |     | NULL    |                |微信带过来的用户信息地区
| sex               | varchar(255) | YES  |     | NULL    |                |性别
| subscribe         | varchar(255) | YES  |     | NULL    |                |是否订阅
| subscribe_time    | datetime     | YES  |     | NULL    |                |订阅时间
| unsubscribe_time  | datetime     | YES  |     | NULL    |                |取消订阅时间
| public_account_id | int(11)      | YES  |     | NULL    |                |对应表publicaccountid
| wechat_open_id    | varchar(255) | YES  |     | NULL    |                |公众号原始id(可以要求管理员填写)
| group_id          | varchar(32)  | YES  |     | NULL    |                |系统所在的组
+-------------------+--------------+------+-----+---------+----------------+
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
		this.set("sys_user_id",suId).set("public_account_id",paId);
		this.save();
	}
	
	/**
	 * 根据publicAccount的id查出userInfo信息
	 */
	public UserInfo findByPublicAccountId(Integer paId) {
		List<UserInfo> result = find("select * from wechat_user_info where public_account_id = '"+paId+"'");
		return result.size() > 0 ? result.get(0) : null;
	}
	
	/**
	 * 验证码验证成功后更新userInfo
	 */
	public void accUpdate(PublicAccount pa, String toUserName, String fromUserName) {
		UserInfo ui = new UserInfo();
		ui = me.findByPublicAccountId(pa.getInt("id"));
		this.set("id",ui.getInt("id")).set("open_id",fromUserName).set("subscribe","true").set("subscribe_time",new Date()).set("wechat_open_id",toUserName);
		this.update();
	}
}
  
