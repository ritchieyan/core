package com.wyrz.core.utils;

/**
 * 字符串处理工具类
 * @author yanziqi
 * @date 2014年12月9日下午3:52:53
 */
public class StringUtil {

	/**
	 * 字符串首字母小写
	 * @author yanziqi
	 * @param str
	 * @return
	 * @date 2014年12月9日下午3:53:09
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isLowerCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}

	/**
	 * 字符串首字母大写
	 * @author yanziqi
	 * @param str
	 * @return
	 * @date 2014年12月9日下午3:53:58
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isUpperCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}
}
