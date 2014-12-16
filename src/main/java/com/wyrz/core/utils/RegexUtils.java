package com.wyrz.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 正则式工具类
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:12:14
 */
public class RegexUtils {
	private static final Logger logger = LoggerFactory.getLogger(RegexUtils.class);
	private static final Pattern enPat = Pattern.compile("[a-zA-Z]+");
	private static final Pattern numPat = Pattern.compile("[0-9]+");
	private static final char[] regexMetaChars = { '(', '[', '{', '\\', '^', '-', '$', '|', '}', ']', ')', '?', '*',
			'+', '.' };

	/**
	 * 字符是否为正则式元字符
	 * 
	 * @author Ritchieyan
	 * @param c
	 * @return true/false--是/不是正则式元字符
	 * @date 2014年12月16日下午10:13:13
	 */
	private static boolean isRegexMetaChar(char c) {
		for (char regex : regexMetaChars) {
			if (c == regex) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 将字符串中的正则式元字符转换成普通字符
	 * 
	 * @author Ritchieyan
	 * @param source
	 * @return
	 * @date 2014年12月16日下午10:13:32
	 */
	public static String str2regex(String source) {
		StringBuffer target = new StringBuffer();
		for (int index = 0; index < source.length(); index++) {
			char c = source.charAt(index);
			if (isRegexMetaChar(c)) {
				target.append("\\").append(c);
			} else {
				target.append(c);
			}
		}
		return target.toString();
	}

	/**
	 * 获取给定字符串的数字字符串
	 * 
	 * @author Ritchieyan
	 * @param str
	 * @return
	 * @date 2014年12月16日下午10:13:56
	 */
	public static String getMatchedNumberStr(String str) {
		return getRegexStr(str, numPat);
	}

	/**
	 * 获取给定字符串的字母字符串
	 * 
	 * @author Ritchieyan
	 * @param str
	 * @return
	 * @date 2014年12月16日下午10:14:08
	 */
	public static String getMatchedEnStr(String str) {
		return getRegexStr(str, enPat);
	}

	/**
	 * 获取字符串中指定类型正则式字符串
	 * 
	 * @author Ritchieyan
	 * @param str
	 * @param pattern
	 * @return
	 * @date 2014年12月16日下午10:14:17
	 */
	public static String getRegexStr(String str, Pattern pattern) {
		Matcher m = pattern.matcher(StringUtils.stripToEmpty(str));
		if (m.find()) {
			return m.group();
		}
		return "";
	}

	/**
	 * <pre>通过正则式自动拆分字符串各部分，如：
	 * ^([a-zA-Z]{1})([a-zA-Z]{1,5})([0-9]{2})(P)([0-9]{5})([a-zA-Z]{1,5})$
	 * 以上正则式可以自动拆分条码号"MGJR14P00002AP"各部分为：M, GJR, 14, P, 00002, AP
	 * 注意：对于需要拆分的部分必需使用括号包裹起来，否则将视为不会拆分
	 * 
	 * @author Ritchieyan
	 * @param source 源字符串
	 * @param pattern 正则式
	 * @return
	 * @date 2014年12月16日下午10:14:28
	 */
	public static List<String> match(String source, String pattern) {
		try {
			if (StringUtils.isBlank(source)) {
				logger.warn("未指定需要拆分的字符串!");
				return null;
			}
			if (StringUtils.isBlank(pattern)) {
				logger.warn("未指定正则式，无法拆分字符串!");
				return null;
			}
			Scanner s = new Scanner(source);
			s.findInLine(pattern);
			MatchResult result = s.match();
			List<String> parts = new ArrayList<String>();
			for (int i = 1; i <= result.groupCount(); i++) {
				parts.add(result.group(i));
			}
			s.close();
			return parts;
		} catch (Exception e) {
			logger.warn("正则式拆分字符串出错", e.getMessage());
			return null;
		}
	}
}
