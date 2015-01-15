package com.touzi.wechat.model;  

import com.jfinal.plugin.activerecord.Model;

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
| id             | int(11)      | NO   | PRI | NULL    | auto_increment |
| accountId      | varchar(255) | YES  |     | NULL    |                |
| appId          | varchar(255) | YES  |     | NULL    |                |
| appSecret      | varchar(255) | YES  |     | NULL    |                |
| inTime         | datetime     | YES  |     | NULL    |                |
| pwd            | varchar(255) | YES  |     | NULL    |                |
| ticket         | varchar(255) | YES  | UNI | NULL    |                |
| token          | varchar(255) | YES  |     | NULL    |                |
| updateTime     | datetime     | YES  |     | NULL    |                |
| url            | varchar(255) | YES  |     | NULL    |                |
| userName       | varchar(255) | YES  |     | NULL    |                |
| validCode      | varchar(255) | YES  |     | NULL    |                |
| validState     | varchar(255) | YES  |     | NULL    |                |
| sysUserId      | int(11)      | YES  | MUL | NULL    |                |
| encodingAESKey | varchar(255) | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
 */
@SuppressWarnings("serial")
public class PublicAccount extends Model<PublicAccount> {
	public static final PublicAccount me = new PublicAccount();
	
}
  
