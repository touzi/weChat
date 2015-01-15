package com.touzi.tools;  

import java.text.SimpleDateFormat;

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
	
	
}
  
