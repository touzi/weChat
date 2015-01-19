package com.touzi.tools;  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/** 
 * @Title: OtherTools.java 
 * @Package com.touzi.tools 
 * @Description: TODO(1.MD5加密2.随机数) 
 * @author touzi 
 * @date 2014年11月10日 下午6:01:15 
 * @version V1.0 
 */
public class OtherTools {

	/**
	 *MD5加密
	 *@author touzi
	 *@param byte[]
	 *@return String 
	 */
	public static String getMD5(byte[] src) {
		StringBuffer sb=new StringBuffer();
        try {
            java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
            md.update(src);
            for(byte b : md.digest())
                sb.append(Integer.toString(b>>>4&0xF,16)).append(Integer.toString(b&0xF,16));
        } catch (NoSuchAlgorithmException e) {}
        return sb.toString();
	}
	
	 /**
     * 获取count个随机数
     * @param count 随机数个数
     * @return
     */
    public static String getRandom(int count){
        StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for(int i=0;i<count;i++){
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num)+""), "");
        }
        return sb.toString();
    }
	
	
	
	public static String urlJson(String GET_URL) throws IOException {
		String lines = null;
		// 拼凑get请求的URL字串，使用URLEncoder.encode对特殊和不可见字符进行编码
		// String getURL = GET_URL + "&activatecode=" +
		// URLEncoder.encode("久酷博客", "utf-8");
		String getURL = GET_URL;
		URL getUrl = new URL(getURL);
		// 根据拼凑的URL，打开连接，URL.openConnection函数会根据URL的类型，
		// 返回不同的URLConnection子类的对象，这里URL是一个http，因此实际返回的是HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		// 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到
		// 服务器
		connection.connect();
		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
		while ((lines = reader.readLine()) != null) {
			// lines = new String(lines.getBytes(), "utf-8");
			reader.close();
			// 断开连接
			connection.disconnect();
			return lines;
		}
		reader.close();
		// 断开连接
		connection.disconnect();
		return lines;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getRandom(4));
	}
}
  
