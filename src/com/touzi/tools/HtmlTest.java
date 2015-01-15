package com.touzi.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

class StreamToString{
	public static String ConvertToString(InputStream inputStream){
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuilder result = new StringBuilder();
		String line = null;
		try {
			while((line = bufferedReader.readLine()) != null){
				result.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				inputStreamReader.close();
				inputStream.close();
				bufferedReader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result.toString();
	}


	public static String ConvertToString(FileInputStream inputStream) throws UnsupportedEncodingException{
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		//BufferedReader br=new BufferedReader(new InputStreamReader(is，“GBK”));
		StringBuilder result = new StringBuilder();
		String line = null;
		try {
			while((line = bufferedReader.readLine()) != null){
				result.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				inputStreamReader.close();
				inputStream.close();
				bufferedReader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result.toString();
	}
}

public class HtmlTest {
	public static void main(String[] args) {
//		try{
//			URL url = new URL("http://123.tlsw.net:8080/dxm/dxms?hm=18600917052&nr=3中放到铁\"商\"务!");
//			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//			//GET Request Define: 
//			urlConnection.setRequestMethod("GET");
//			
//			urlConnection.connect();
//			
//			//Connection Response From Test Servlet
//			System.out.println("Connection Response From Test Servlet");
//			InputStream inputStream = urlConnection.getInputStream();
//			
//			//Convert Stream to String
//			String responseStr = StreamToString.ConvertToString(inputStream);
//			//responseStr = responseStr
//			System.out.println(responseStr);
//		}catch(IOException e){
//			Logger.getLogger(HtmlTest.class.getName()).log(Level.SEVERE, null, e);
//		}
		
		
		
		
		try{
		String path = "http://123.tlsw.net:8080/dxm/dxms?hm=18600917052&nr=3中放到铁\"商\"务!";// 实验环境中使用pc的ip，不能用localhost或127.0.0.1
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestProperty("Accept-Charset", "GBK");
		conn.setRequestProperty("contentType", "GBK");
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		InputStream inStream = conn.getInputStream();
//		readLesoSysXML(inStream);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "GBK"));
	    StringBuffer buffer = new StringBuffer();
	    String line = "";
	    while ((line = in.readLine()) != null){
	      buffer.append(line);
	    }
	   String str = buffer.toString();
	   System.out.println(str);
		}catch(IOException e){
			Logger.getLogger(HtmlTest.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
