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
 * mysql> describe wechatReqMsgLog;
+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| id              | varchar(32)  | NO   | PRI | NULL    |       |
| createTime      | datetime     | YES  |     | NULL    |       |创建时间
| inEventType     | varchar(255) | YES  |     | NULL    |       |消息事件来源(关注,取消关注,按钮,查看,位置,语音,图片,视频,连接,二维码)
| inFromUserName  | varchar(255) | YES  |     | NULL    |       |发送方帐号（一个OpenID）
| inToUserName    | varchar(255) | YES  |     | NULL    |       |开发者微信号
| inContent       | longtext     | YES  |     | NULL    |       |发送消息内容
| inTime          | datetime     | YES  |     | NULL    |       |发送时间
| msgId           | bigint(20)   | YES  |     | NULL    |       |接收微信的消息时中有
| outEventType    | varchar(255) | YES  |     | NULL    |       |回复消息类型
| outTime         | datetime     | YES  |     | NULL    |       |回调时间
| outContent      | longtext     | YES  |     | NULL    |       |回复消息内容
| outFromUserName | varchar(255) | YES  |     | NULL    |       |开发者微信号
| outToUserName   | varchar(255) | YES  |     | NULL    |       |接收方帐号（收到的OpenID）
| publicAccountId | int(11)      | NO   | MUL | NULL    |       |wechatPublicAccount的id
+-----------------+--------------+------+-----+---------+-------+
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
		this.set("createTime",createTime).set("inEventType",inMsg.getMsgType()).set("inFromUserName",inMsg.getFromUserName())
		.set("inToUserName",inMsg.getToUserName()).set("inContent",inMsg.getContent()).set("inTime",DateTools.getCurrentDate())
		.set("msgId",inMsg.getMsgId())
		.set("outEventType",outMsg.getMsgType()).set("outTime",outTime).set("outContent",outMsg.getContent())
		.set("outFromUserName",outMsg.getFromUserName())
		.set("outToUserName",outMsg.getToUserName()).set("publicAccountId",pa.getInt("id"));
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
		this.set("createTime",createTime).set("inEventType",inMsg.getMsgType()).set("inFromUserName",inMsg.getFromUserName())
		.set("inToUserName",inMsg.getToUserName()).set("inContent",inMsg.getContent()).set("inTime",DateTools.getCurrentDate())
		.set("msgId",inMsg.getMsgId())
		.set("outEventType",outMsg.getMsgType()).set("outTime",outTime).set("outContent",outContent)
		.set("outFromUserName",outMsg.getFromUserName())
		.set("outToUserName",outMsg.getToUserName()).set("publicAccountId",pa.getInt("id"));
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
		this.set("createTime",createTime).set("inEventType",inMsg.getMsgType()).set("inFromUserName",inMsg.getFromUserName())
		.set("inToUserName",inMsg.getToUserName()).set("inContent",inMsg.getContent()).set("inTime",DateTools.getCurrentDate())
		.set("msgId",inMsg.getMsgId())
		.set("outEventType",outMsg.getMsgType()).set("outTime",outTime).set("outContent",outContent)
		.set("outFromUserName",outMsg.getFromUserName())
		.set("outToUserName",outMsg.getToUserName()).set("publicAccountId",pa.getInt("id"));
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
		this.set("createTime",createTime).set("inEventType",inMsg.getMsgType()).set("inFromUserName",inMsg.getFromUserName())
		.set("inToUserName",inMsg.getToUserName()).set("inContent",inMsg.getContent()).set("inTime",DateTools.getCurrentDate())
		.set("msgId",inMsg.getMsgId())
		.set("outEventType","text").set("outTime",DateTools.getCurrentDate()).set("outContent",outMsg)
		.set("outFromUserName",inMsg.getToUserName())
		.set("outToUserName",inMsg.getFromUserName()).set("publicAccountId",pa.getInt("id"));
		this.save();
	}
	
}
  
