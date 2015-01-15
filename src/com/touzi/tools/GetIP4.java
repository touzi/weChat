package com.touzi.tools;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * @Title: GetIP.java
 * @Package com.touzi.tools
 * @Description: TODO(获取IP4)
 * @author touzi
 * @date 2014年11月27日 下午4:17:27
 * @version V1.0
 */

public class GetIP4 {
	private static final Logger log = Logger.getLogger(GetIP4.class);

	/**
	 * 获取客户端真实IP地址（注意：如果通过Squid反向代理软件，需更改squid.conf配置文件forwarded_for项默认是为on，
	 * 否则获取到的IP为unknown）
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static String getIpAddr(HttpServletRequest request) {
//		log.warn("====================================================");
		if (log.isDebugEnabled()) {
			StringBuffer buf = new StringBuffer("all head info:\n");
			Enumeration enumeration = request.getHeaderNames();
			while (enumeration.hasMoreElements()) {
				Object head = enumeration.nextElement();
				if (null != head) {
					String value = request.getHeader(String.valueOf(head));
					buf.append(head + "=" + value + "\n");
				}
			}
//			log.warn(buf.toString());
		}

		String ip = request.getHeader("x-forwarded-for");
//		log.warn("request.getHeader(\"x-forwarded-for\")=" + ip);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
//			log.warn("request.getHeader(\"X-Forwarded-For\")=" + ip);
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
//			log.warn("request.getHeader(\"Proxy-Client-IP\")=" + ip);
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
//			log.warn("request.getHeader(\"WL-Proxy-Client-IP\")=" + ip);
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
//			log.warn("request.getHeader(\"HTTP_CLIENT_IP\")=" + ip);
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//			log.warn("request.getHeader(\"HTTP_X_FORWARDED_FOR\")=" + ip);
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
//			log.warn("request.getRemoteAddr()=" + ip);
		}

		if (null != ip && ip.indexOf(',') != -1) {
			// 如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串 IP 值
			// 取X-Forwarded-For中第一个非unknown的有效IP字符串
			// 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
			// 192.168.1.100
			// 用户真实IP为： 192.168.1.110
			// 注意:当访问地址为 localhost 时 地址格式为 0:0:0:0:0:0:1
//			log.warn("ip=" + ip);
			String[] ips = ip.split(",");
			for (int i = 0; i < ips.length; i++) {
				if (null != ips[i] && !"unknown".equalsIgnoreCase(ips[i])) {
					ip = ips[i];
					break;
				}
			}
			if ("0:0:0:0:0:0:1".equals(ip)) {
//				log.warn("由于客户端访问地址使用 localhost，获取客户端真实IP地址错误，请使用IP方式访问");
			}
		}

		if ("unknown".equalsIgnoreCase(ip)) {
//			log.warn("由于客户端通过Squid反向代理软件访问，获取客户端真实IP地址错误，请更改squid.conf配置文件forwarded_for项默认是为on解决");
		}
//		log.warn("====================================================");
		return ip;
	}
}
