package com.touzi.tools;  

import java.net.HttpRetryException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.eclipse.jetty.server.Request;

/** 
 * @Title: TextMD5.java 
 * @Package com.touzi.tools 
 * @Description: TODO(描述對密碼進行加密和驗證的類) 
 * @author touzi 
 * @date 2014年11月26日 下午3:27:25 
 * @version V1.0 
 */
public class TextMD5 {
	private final static String[] hexDigite = {"0","1","2","3","4","5"
        ,"6","7","8","9","a","b","c","d","e","f"};  //十六進制數字到字符的映射數組
    public static String createPassword(String inputString){    //把inputString加密
        return encodeByMD5(inputString);
         
    }
    //驗證輸入的密碼是否正確，password：真正的密碼
    public static boolean isPassword(String password,String inputString){
        if(password.equals(encodeByMD5(inputString))){
            return true;
        }else{
            return false;
        }
    }
    //對字符進行MD5加密
    private static String encodeByMD5(String originString){
        if(originString != null){
            try {
                //創建具有指定算法名稱的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用指定的字節數組對摘要進行最後更新，完成摘要計算
                byte[] results = md.digest(originString.getBytes());
                //得到的字節數組變成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();  //返回加密后的字符串
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //轉換字節數組為十六進制字符串
    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            //調用方法方法將字節數組轉為十六進制字符串
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();     //返回十進制字符串
         
    }
    //將一個字節轉化成十六進制形式字符串
    private static String byteToHexString(byte b){
        int n=b;
        if( n < 0)
            n = 256 + n;
            int d1 = n / 16;
            int d2 = n % 16;
            return hexDigite[d1] + hexDigite[d2];
    }
    public static void main(String[] args) {
        String password = TextMD5.createPassword("888888");
        System.out.println("對888888用MD5加密后的字符：\r\n"+password);
         
        String inputString = "8888";
        System.out.println("8888和密碼是否匹配？"+TextMD5.isPassword(password, inputString));
         
        inputString = "888888";
        System.out.println("888888和密碼是否匹配？"+TextMD5.isPassword(password, inputString));
    	
    }
}
  
