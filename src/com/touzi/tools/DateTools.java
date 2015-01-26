package com.touzi.tools;  

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @Title: DateTools.java 
 * @Package com.touzi.tools 
 * @Description: TODO(对各种时间的处理) 
 * @author touzi 
 * @date 2014年11月10日 下午5:44:39 
 * @version V1.0 
 */
public class DateTools {
	
	/**
	 * 获取当前日期的字符串表示形式
	 * @see yyyy-MM-dd HH:mm:ss
	 * @author touzi
	 * @return String 
	 */ 
	public static String getCurrentDate() {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return dateFormat.format(System.currentTimeMillis());
	}
	
	/**
	 * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param createTime 消息创建时间
	 * @return
	 */
	public static String formatTime(String createTime) {
		// 将微信传入的CreateTime转换成long类型，再乘以1000
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(msgCreateTime));
	}
	
	public static void main(String[] args) {
		System.out.println(formatTime("1421830394"));
	}
	
}
  
