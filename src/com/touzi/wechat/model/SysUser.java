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
	
	/**
	 * 保存注册用户信息
	 */
	public void mySave() {
		String pw = OtherTools.getMD5(this.getStr("pwd").getBytes());
		this.set("pwd", pw).set("isValid",1).set("score",0).set("inTime", DateTools.getCurrentDate());
		this.save();
	}
	
	/**
	 * 验证email是否可用
	 */
	public boolean containEmail(String email) {
		return me.findFirst("select email from wechatSysUser where email = ? limit 1 ",email) != null;
	}
	
	/**
	 * 验证用户名是否可用
	 */
	public boolean containUser(String userName) {
		return me.findFirst("select userName from wechatSysUser where userName = ? limit 1 ",userName) != null;
	}
}
  
