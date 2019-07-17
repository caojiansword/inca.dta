package com.inca.utils;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName:StringHelper.java 
 * @Description:String操作处理
 * @author:王开展
 * @date:2018年12月4日
 */

public class StringHelper {

	/**
	 * 默认的空值
	 */
	public static final String EMPTY = "";
	

	/**
	 * 转换成字符串,如果对象为Null,则返回空字符串
	 * @param obj 需要判断的对象数组
	 * @return boolean
	 */
	public static String valueOf(Object obj) {
		if (obj != null) {
			return obj.toString();
		}
		return "";
	}

	/**
	 * 检查字符串是否为空
	 * @param str 字符串
	 * @return
	 */
	public static boolean isEmpty(Object str) {
		if (str == null) {
			return true;
		}
		if (valueOf(str).trim().length() == 0) {
			return true;
		} 
		if ("null".equalsIgnoreCase(valueOf(str).trim())) {
			return true;
		}
		
		return false;
	}

	/**
	 * 检查字符串是否不为空
	 * @param str 字符串
	 * @return
	 */
	public static boolean isNotEmpty(Object str) {
		return !isEmpty(str);
	}

	/**
	 * 截取并保留标志位之前的字符串
	 * @param str 字符串
	 * @param expr 分隔符
	 * @return
	 */
	public static String substringBefore(String str, String expr) {
		if (isEmpty(str)) {
			return str;
		}
		int pos = str.indexOf(expr);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * 截取并保留标志位之后的字符串
	 * @param str 字符串
	 * @param expr 分隔符
	 */
	public static String substringAfter(String str, String expr) {
		if (isEmpty(str)) {
			return str;
		}
		int pos = str.indexOf(expr);
		if (pos == -1) {
			return EMPTY;
		}
		return str.substring(pos + expr.length());
	}

	/**
	 * 截取并保留最后一个标志位之前的字符串
	 * @param str 字符串
	 * @param expr 分隔符
	 * @return
	 */
	public static String substringBeforeLast(String str, String expr) {
		if (isEmpty(str) || isEmpty(expr)) {
			return str;
		}
		int pos = str.lastIndexOf(expr);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * 截取并保留最后一个标志位之后的字符串
	 * @param str 字符串
	 * @param expr 分隔符
	 */
	public static String substringAfterLast(String str, String expr) {
		if (isEmpty(str)) {
			return str;
		}
		if (isEmpty(expr)) {
			return EMPTY;
		}
		int pos = str.lastIndexOf(expr);
		if (pos == -1 || pos == (str.length() - expr.length())) {
			return EMPTY;
		}
		return str.substring(pos + expr.length());
	}

	/**
	 * 把字符串按分隔符转换为数组
	 * @param string 字符串
	 * @param expr 分隔符
	 * @return
	 */
	public static String[] split(String string, String expr) {
		if (isEmpty(string) || isEmpty(expr)) {
			return null;
		}
		return string.split(expr);
	}

	/**
	 * 去除字符串中的空格
	 */
	public static String noSpace(String str) {
		str = str.trim();
		str = str.replace(" ", "_");
		return str;
	}
	
	/**
	 * 获取字符串的编码格式
	 */
	public static String getEncoding(String str) {
		try {
			String encode = "GB2312";
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
			encode = "ISO-8859-1";
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
			encode = "UTF-8";
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
			encode = "GBK";
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 判断是否包含中文
	 */
	public static boolean contailsChinese(String str) {
		if (isEmpty(str)) {
			return false;
		}
		String regExp = ".*[\u4e00-\u9fa5]{1,}.";
		return doRegExpMatch(regExp, str);
	}

	/**
	 * 正则表达式判断
	 */
	private static boolean doRegExpMatch(String regExp, String str) {
		Matcher m = Pattern.compile(regExp).matcher(str);
		return m.matches();
	}

}
