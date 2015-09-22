package com.ykh.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 字符串工具类.
 */
public abstract class StringUtils {
	
	private static final String SEED_FOR_RANDOM_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private StringUtils() {}
	
	/**
	 * 拼接字符串.
	 * 
	 * @param parts 待拼接的字符串组成部分的列表.
	 * @return 拼接成的字符串.
	 */
	public static String strcat(Object... parts)
	{
		final StringBuilder sb = new StringBuilder();
		for (Object part : parts) {
			sb.append(part);
		}
		return sb.toString();
	}
	
	public static String qstrep(String src, String allowedRegex, boolean paramCanBeBlank, String... params)
	{
		String questionTempPlaceHolder = "!@#$% QUESTION %$#@!";
		src = src.replace("\\?", questionTempPlaceHolder);
		final StringBuilder sb = new StringBuilder();
		int indexOfParam = 0;
		for (int i = 0; i < src.length(); i++) {
			int c = src.codePointAt(i);
			if (c == '?') {
				if (indexOfParam < params.length) {
					String param = params[indexOfParam++];
					param = param.replaceAll(strcat("[^", allowedRegex, "]"), "");
					if (!paramCanBeBlank) {
						if (param.length() < 1) {
							return null;
						}
					}
					sb.append(param);
				}
			} else {
				sb.appendCodePoint(c);
			}
		}
		return sb.toString().replace(questionTempPlaceHolder, "\\?");
	}
	
	/**
	 * 返回定长的随机字符串. 字符范围为[0-9a-zA-Z].
	 * 
	 * @param length 字符串长度.
	 * @return 随机字符串.
	 */
	public static String randomString(int length)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(SEED_FOR_RANDOM_STRING.charAt((int) (Math.random() * SEED_FOR_RANDOM_STRING.length())));
		}
		return sb.toString();
	}
	
	/**
	 * 将null变为空字符串.
	 * 
	 * @param string 字符串.
	 * @return 若参数为null, 返回空字符串; 否则返回trim过的参数字符串.
	 */
	public static String nullToBlankString(String string)
	{
		if (string == null) {
			return "";
		} else {
			return string.trim();
		}
	}
	
	/**
	 * 判断是否参数中的所有字符串的长度均在指定的最大长度内.
	 * 允许字符串为null.
	 * 
	 * @param maxLength 最大长度.
	 * @param strings 字符串数组.
	 * @return 是否参数中的所有字符串的长度均在指定的最大长度内.
	 */
	public static boolean allInBound(int maxLength, String... strings)
	{
		for (String string : strings) {
			if (string == null) {
				continue;
			}
			if (string.length() > maxLength) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmpty(String ip) {
		return !(ip != null && !"".equals(ip));
	}
    
    /** 
     * Get XML String of utf-8 
     *  
     * @return XML-Formed string 
     */  
     public static String getUTF8XMLString(String xml) {  
	     // A StringBuffer Object  
	     StringBuffer sb = new StringBuffer();  
	     sb.append(xml);  
	     String xmString = "";  
	     String xmlUTF8="";  
	     try {  
		     xmString = new String(sb.toString().getBytes("UTF-8"));  
		     xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");  
		     System.out.println("utf-8 编码：" + xmlUTF8) ;  
	     } catch (UnsupportedEncodingException e) {  
		     // TODO Auto-generated catch block  
		     e.printStackTrace();  
	     }  
	     // return to String Formed  
	     return xmlUTF8;  
     } 

}
