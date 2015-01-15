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
| sysUserId       | int(11)      | YES  |     | NULL    |                |
| city            | varchar(255) | YES  |     | NULL    |                |
| country         | varchar(255) | YES  |     | NULL    |                |
| headimgUrl      | varchar(255) | YES  |     | NULL    |                |
| language        | varchar(255) | YES  |     | NULL    |                |
| nickName        | varchar(255) | YES  |     | NULL    |                |
| openId          | varchar(255) | YES  |     | NULL    |                |
| province        | varchar(255) | YES  |     | NULL    |                |
| sex             | varchar(255) | YES  |     | NULL    |                |
| subscribe       | varchar(255) | YES  |     | NULL    |                |
| subscribeTime   | datetime     | YES  |     | NULL    |                |
| unsubscribeTime | datetime     | YES  |     | NULL    |                |
| publicAccountId | int(11)      | NO   | MUL | NULL    |                |
| wechatOpenId    | varchar(255) | YES  |     | NULL    |                |
| groupId         | varchar(32)  | YES  | MUL | NULL    |                |
+-----------------+--------------+------+-----+---------+----------------+
16 rows in set
 */
@SuppressWarnings("serial")
public class UserInfo extends Model<UserInfo> {
	public static final UserInfo me = new UserInfo();
}
  
