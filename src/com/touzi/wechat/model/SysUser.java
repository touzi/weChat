package com.touzi.wechat.model;  

import com.jfinal.plugin.activerecord.Model;
import com.touzi.tools.OtherTools;

/** 
 * @Title: SysUser.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(管理员用户model) 
 * @author touzi 
 * @date 2015年1月15日 下午4:09:57 
 * @version V1.0 
 * mysql> describe wechatSysUser;
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| email    | varchar(255) | YES  |     | NULL    |                |
| inTime   | datetime     | YES  |     | NULL    |                |
| isValid  | varchar(255) | YES  |     | NULL    |                |
| phoneNo  | varchar(255) | YES  |     | NULL    |                |
| pwd      | varchar(255) | YES  |     | NULL    |                |
| score    | int(11)      | NO   |     | 0       |                |
| userName | varchar(255) | YES  |     | NULL    |                |
| validUid | varchar(255) | YES  | UNI | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
9 rows in set
 */
@SuppressWarnings("serial")
public class SysUser extends Model<SysUser> {
	public static final SysUser me = new SysUser();
	
	
	/**
	 * 判断登录
	 */
	public SysUser getUserNameAndPassWord(String userName, String passWord) {
		String pwd = OtherTools.getMD5(passWord.getBytes());
		return findFirst("select * from wechatSysUser where userName = ? and pwd = ? ",userName,pwd);
	}
}
  
