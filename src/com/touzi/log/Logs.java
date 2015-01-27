package com.touzi.log;  

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.plugin.activerecord.Model;
import com.touzi.tools.DateTools;
import com.touzi.tools.GetIP4;
import com.touzi.wechat.model.SysUser;

/** 
 * @Title: Log.java 
 * @Package com.touzi.log 
 * @Description: TODO(添加描述) 
 * @author touzi 
 * @date 2014年11月27日 下午1:58:56 
 * @version V1.0 
 * 
 *mysql> describe wechat_sys_log;
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | int(11)      | NO   | PRI | NULL    | auto_increment |
| ip           | varchar(255) | YES  |     | NULL    |                |
| user_id      | int(11)      | NO   |     | NULL    |                |
| user_name    | varchar(255) | YES  |     | NULL    |                |
| log_info     | longtext     | YES  |     | NULL    |                |
| log_datetime | datetime     | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
6 rows in set
 */
@SuppressWarnings("serial")
public class Logs extends Model<Logs> {
	
	public static final Logs me = new Logs();
	
	public List<Logs> findAll() {
		return find("select * from wechat_sys_log order by id desc ");
	}
	
	/**
	 * session中的users
	 * request
	 * info内容
	 */
	public static void logInfo(Object users, HttpServletRequest request, String info) {
		String ip = GetIP4.getIpAddr(request);
		if(users != null){
			SysUser user = (SysUser) users;
			me.set("ip", ip).set("user_id", user.getInt("id")).set("user_name", user.getStr("user_name")).set("log_datetime", DateTools.getCurrentDate()).set("log_info", info);
			me.save();
			me.clear();
		}else {
			me.set("ip", ip).set("user_id", 0).set("user_name", "error").set("log_datetime", DateTools.getCurrentDate()).set("log_info", info);
			me.save();
			me.clear();
		}
	}
}
  
