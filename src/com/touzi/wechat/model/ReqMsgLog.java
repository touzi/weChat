package com.touzi.wechat.model;  

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.out.News;
import com.jfinal.weixin.sdk.msg.out.OutMusicMsg;
import com.jfinal.weixin.sdk.msg.out.OutNewsMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import com.touzi.tools.DateTools;

/** 
 * @Title: ReqMsgLog.java 
 * @Package com.touzi.wechat.model 
 * @Description: TODO(添加描述) 
 * @author touzi 
 * @date 2015年1月22日 下午3:22:06 
 * @version V1.0 
 * mysql> describe wechat_req_msg_log;
+--------------------+--------------+------+-----+---------+----------------+
| Field              | Type         | Null | Key | Default | Extra          |
+--------------------+--------------+------+-----+---------+----------------+
| id                 | int(11)      | NO   | PRI | NULL    | auto_increment |
| create_time        | datetime     | YES  |     | NULL    |                |创建时间
| in_event_type      | varchar(255) | YES  |     | NULL    |                |消息事件来源(关注,取消关注,按钮,查看,位置,语音,图片,视频,连接,二维码)
| in_from_user_name  | varchar(255) | YES  |     | NULL    |                |发送方帐号（一个OpenID）
| in_to_user_name    | varchar(255) | YES  |     | NULL    |                |开发者微信号
| in_content         | longtext     | YES  |     | NULL    |                |发送消息内容
| in_time            | datetime     | YES  |     | NULL    |                |发送时间
| msg_id             | bigint(20)   | YES  |     | NULL    |                |接收微信的消息时中有
| out_event_type     | varchar(255) | YES  |     | NULL    |                |回复消息类型
| out_time           | datetime     | YES  |     | NULL    |                |回调时间
| out_content        | longtext     | YES  |     | NULL    |                |回复消息内容
| out_from_user_name | varchar(255) | YES  |     | NULL    |                |开发者微信号
| out_to_user_name   | varchar(255) | YES  |     | NULL    |                |接收方帐号（收到的OpenID）
| public_account_id  | int(11)      | NO   |     | NULL    |                |wechatPublicAccount的id
+--------------------+--------------+------+-----+---------+----------------+
 */
@SuppressWarnings("serial")
public class ReqMsgLog extends Model<ReqMsgLog> {
	public static final ReqMsgLog me = new ReqMsgLog();
	
	/**
	 * @author touzi
	 * @dateTime 2015年1月23日下午5:18:14
	 * @Title: msgSave 
	 * @Description: TODO(文本消息) 
	 * @param @param inMsg
	 * @param @param outMsg
	 * @param @param pa    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void saveInTextMsg(InTextMsg inMsg, OutTextMsg outMsg, PublicAccount pa) {
		String createTime = DateTools.formatTime(inMsg.getCreateTime().toString());
		String outTime = DateTools.formatTime(outMsg.getCreateTime().toString());
		this.set("create_time",createTime).set("in_event_type",inMsg.getMsgType()).set("in_from_user_name",inMsg.getFromUserName())
		.set("in_to_user_name",inMsg.getToUserName()).set("in_content",inMsg.getContent()).set("in_time",DateTools.getCurrentDate())
		.set("msg_id",inMsg.getMsgId())
		.set("out_event_type",outMsg.getMsgType()).set("out_time",outTime).set("out_content",outMsg.getContent())
		.set("out_from_user_name",outMsg.getFromUserName())
		.set("out_to_user_name",outMsg.getToUserName()).set("public_account_id",pa.getInt("id"));
		this.save();
	}
	
	/**
	 * @author touzi
	 * @dateTime 2015年1月23日下午5:17:09
	 * @Title: msgSave 
	 * @Description: TODO(图文消息) 
	 * @param @param inMsg
	 * @param @param outMsg
	 * @param @param pa    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void saveInTextMsg(InTextMsg inMsg, OutNewsMsg outMsg, PublicAccount pa) {
		String createTime = DateTools.formatTime(inMsg.getCreateTime().toString());
		String outTime = DateTools.formatTime(outMsg.getCreateTime().toString());
		String outContent = "";
		News news = new News();
		for(int i = 0; i < outMsg.getArticles().size(); i++) {
			news = outMsg.getArticles().get(i);
			outContent += i + ":" + news.getTitle() + "|" + news.getDescription() + "|" + news.getPicUrl() + "|" + news.getUrl();
		}
		this.set("create_time",createTime).set("in_event_type",inMsg.getMsgType()).set("in_from_user_name",inMsg.getFromUserName())
		.set("in_to_user_name",inMsg.getToUserName()).set("in_content",inMsg.getContent()).set("in_time",DateTools.getCurrentDate())
		.set("msg_id",inMsg.getMsgId())
		.set("out_event_type",outMsg.getMsgType()).set("out_time",outTime).set("out_content",outContent)
		.set("out_from_user_name",outMsg.getFromUserName())
		.set("out_to_user_name",outMsg.getToUserName()).set("public_account_id",pa.getInt("id"));
		this.save();
	}
	
	/**
	 * @author touzi
	 * @dateTime 2015年1月23日下午5:21:43
	 * @Title: msgSave 
	 * @Description: TODO(音乐消息) 
	 * @param @param inMsg
	 * @param @param outMsg
	 * @param @param pa    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void saveInTextMsg(InTextMsg inMsg, OutMusicMsg outMsg, PublicAccount pa) {
		String createTime = DateTools.formatTime(inMsg.getCreateTime().toString());
		String outTime = DateTools.formatTime(outMsg.getCreateTime().toString());
		String outContent = outMsg.getTitle() + "|" + outMsg.getDescription() + "|" + outMsg.getHqMusicUrl() + "|" + outMsg.getMusicUrl();
		this.set("create_time",createTime).set("in_event_type",inMsg.getMsgType()).set("in_from_user_name",inMsg.getFromUserName())
		.set("in_to_user_name",inMsg.getToUserName()).set("in_content",inMsg.getContent()).set("in_time",DateTools.getCurrentDate())
		.set("msg_id",inMsg.getMsgId())
		.set("out_event_type",outMsg.getMsgType()).set("out_time",outTime).set("out_content",outContent)
		.set("out_from_user_name",outMsg.getFromUserName())
		.set("out_to_user_name",outMsg.getToUserName()).set("public_account_id",pa.getInt("id"));
		this.save();
	}
	
	
	/**
	 * @author touzi
	 * @dateTime 2015年1月23日下午5:37:06
	 * @Title: msgSave 
	 * @Description: TODO(其他文本消息) 
	 * @param @param inMsg
	 * @param @param outMsg
	 * @param @param pa    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void saveInTextMsg(InTextMsg inMsg, String outMsg, PublicAccount pa) {
		String createTime = DateTools.formatTime(inMsg.getCreateTime().toString());
		this.set("create_time",createTime).set("in_event_type",inMsg.getMsgType()).set("in_from_user_name",inMsg.getFromUserName())
		.set("in_to_user_name",inMsg.getToUserName()).set("in_content",inMsg.getContent()).set("in_time",DateTools.getCurrentDate())
		.set("msg_id",inMsg.getMsgId())
		.set("out_event_type","text").set("out_time",DateTools.getCurrentDate()).set("out_content",outMsg)
		.set("out_from_user_name",inMsg.getToUserName())
		.set("out_to_user_name",inMsg.getFromUserName()).set("public_account_id",pa.getInt("id"));
		this.save();
	}
	
}
  
