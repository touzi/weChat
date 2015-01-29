package com.touzi.wechat.model;  

import com.jfinal.plugin.activerecord.Model;

/** 
 * @Title: Material.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(素材表) 
 * @author touzi 
 * @date 2015年1月28日 上午10:25:47 
 * @version V1.0 
 * mysql> describe wechat_material;
+-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| id                | int(11)      | NO   | PRI | NULL    | auto_increment |
| msg_type          | varchar(255) | YES  |     | NULL    |                |回复消息类型
| title             | varchar(255) | YES  |     | NULL    |                |标题(除多图文的其他图文消息内容只填写标题用作处理)
| description       | varchar(255) | YES  |     | NULL    |                |简介(单图文必填,多图文不用填)
| pic_url           | varchar(255) | YES  |     | NULL    |                |封面图片地址(音频消息做音乐地址)
| url               | varchar(255) | YES  |     | NULL    |                |对应的微信图文地址(音频消息做高清地址)
| item              | varchar(255) | YES  |     | NULL    |                |图文组(使用时间戳md5记录)(音频消息做是否标星1为是0为否)
| sys_user_id       | int(11)      | NO   |     | NULL    |                |sysUserId对应用户表id
| public_account_id | int(11)      | NO   |     | NULL    |                |publicAccountId对应公众号表id
| in_time           | datetime     | YES  |     | NULL    |                |
| update_time       | datetime     | YES  |     | NULL    |                |
+-------------------+--------------+------+-----+---------+----------------+
11 rows in set (0.01 sec)
 */
@SuppressWarnings("serial")
public class Material extends Model<Material> {
	public static final Material me = new Material();
	
}
  
