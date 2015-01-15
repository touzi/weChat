package com.touzi.wechat.model;  

import com.jfinal.plugin.activerecord.Model;

/** 
 * @Title: UserGroup.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(用户组model) 
 * @author touzi 
 * @date 2015年1月15日 下午4:15:07 
 * @version V1.0 
 * mysql> describe wechatUserGroup;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| id     | int(11)      | NO   | PRI | NULL    | auto_increment |
| inTime | datetime     | YES  |     | NULL    |                |
| name   | varchar(255) | YES  |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+
3 rows in set
 */
@SuppressWarnings("serial")
public class UserGroup extends Model<UserGroup> {
	public static final UserGroup me = new UserGroup();
}
  
