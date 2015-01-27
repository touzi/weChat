package com.touzi.wechat.model;  

import com.jfinal.plugin.activerecord.Model;
import com.touzi.tools.DateTools;
import com.touzi.tools.OtherTools;

/** 
 * @Title: SysUser.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(管理员用户model) 
 * @author touzi 
 * @date 2015年1月15日 下午4:09:57 
 * @version V1.0 
 * mysql> describe wechat_sys_user;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int(11)      | NO   | PRI | NULL    | auto_increment |
| email      | varchar(255) | YES  |     | NULL    |                |
| in_time    | datetime     | YES  |     | NULL    |                |
| is_valid   | varchar(255) | YES  |     | NULL    |                |
| phone_no   | varchar(255) | YES  |     | NULL    |                |
| pwd        | varchar(255) | YES  |     | NULL    |                |
| score      | int(11)      | NO   |     | 0       |                |
| user_name  | varchar(255) | YES  |     | NULL    |                |
| valid_u_id | varchar(255) | YES  |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
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
		return findFirst("select * from wechat_sys_user where user_name = ? and pwd = ? ",userName,pwd);
	}
	
	/**
	 * 保存注册用户信息
	 */
	public void mySave() {
		String pw = OtherTools.getMD5(this.getStr("pwd").getBytes());
		this.set("pwd", pw).set("is_valid",1).set("score",0).set("in_time", DateTools.getCurrentDate());
		this.save();
	}
	
	/**
	 * 验证email是否可用
	 */
	public boolean containEmail(String email) {
		return me.findFirst("select email from wechat_sys_user where email = ? limit 1 ",email) != null;
	}
	
	/**
	 * 验证用户名是否可用
	 */
	public boolean containUser(String userName) {
		return me.findFirst("select user_name from wechat_sys_user where user_name = ? limit 1 ",userName) != null;
	}
}
  
