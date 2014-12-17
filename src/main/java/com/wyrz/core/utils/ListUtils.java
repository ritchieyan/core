package com.wyrz.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.wyrz.core.formatter.msg.StringFormatter;

/**
 * 列表工具类
 * 
 * @author Ritchieyan
 * @date 2014年12月17日下午12:09:37
 */
public class ListUtils {

	/**
	 * 将给定的字符串数据构建一个列表类型对象
	 * @author Ritchieyan
	 * @param params
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static List<String> createList(String... params) {
		return array2List(params);
	}

	/**
	 * 将给定的数据对象构建一个列表类型对象
	 * @author Ritchieyan
	 * @param params
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static <S> List<S> createList(S... params) {
		if (params == null) {
			return null;
		}
		List<S> targets = new ArrayList<S>();
		for (S param : params) {
			targets.add(param);
		}
		return targets;
	}

	/**
	 * 合并给定两个列表数据到一个新列表中，源列表始终会排在前面,不会影响源和目标数据列表
	 * @author Ritchieyan
	 * @param sources
	 * @param targets
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static <T> List<T> mergerList(List<T> sources, List<T> targets) {
		List<T> results = new ArrayList<T>();
		if (CollectionUtils.isNotEmpty(sources)) {
			results.addAll(sources);
		}
		if (CollectionUtils.isNotEmpty(targets)) {
			results.addAll(targets);
		}
		return results;
	}

	/**
	 * 将给定的列表合并成一个列表
	 * @author Ritchieyan
	 * @param sources
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static <T> List<T> mergerList(List<List<T>> sources) {
		List<T> results = new ArrayList<T>();
		if (CollectionUtils.isEmpty(sources)) {
			return results;
		}
		for (List<T> source : sources) {
			if (CollectionUtils.isNotEmpty(source)) {
				results.addAll(source);
			}
		}
		return results;
	}

	/**
	 * 将字符串(以逗号分隔，如:A,B,C)解析成List
	 * @author Ritchieyan
	 * @param str
	 * @return 若未指定字符串则返回空列表
	 * @date 2014年12月17日下午12:09:37
	 */
	public static List<String> str2List(String str) {
		return str2List(str, ",");
	}

	/**
	 * 将字符串(以指定分隔符分隔，如:A,B,C)解析成List
	 * @author Ritchieyan
	 * @param str
	 * @param separator 分隔符，若未给定则返回只包含指定字符串的列表
	 * @return 若未指定字符串则返回空列表
	 * @date 2014年12月17日下午12:09:37
	 */
	public static List<String> str2List(String str, String separator) {
		String[] array = StringUtils.split(str, separator);
		if (ArrayUtils.isEmpty(array)) {
			return new ArrayList<String>();
		}
		return array2List(array);
	}

	/**
	 * 将字符串列表对象转换成字符串数组对象，如果list为null或空列表，则返回null
	 * @author Ritchieyan
	 * @param list 要转换的字符串列表对象
	 * @return 字符串数组
	 * @date 2014年12月17日下午12:09:37
	 */
	public static String[] list2Array(List<String> list) {
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		String[] strArray = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			strArray[i] = list.get(i);
		}
		return strArray;
	}

	/**
	 * 将字符串数组转换成以逗号分隔的字符串
	 * @author Ritchieyan
	 * @param array
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static String array2Str(String[] array) {
		return array2Str(array, ",");
	}

	/**
	 * 以指定分隔符构建字符串
	 * @author Ritchieyan
	 * @param words
	 * @param separator
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static String array2Str(String[] words, String separator) {
		if (ArrayUtils.isEmpty(words)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			if (StringUtils.isEmpty(word)) {
				continue;
			}
			sb.append(word).append(separator);
		}
		return StringUtils.removeEnd(sb.toString(), separator);
	}

	/**
	 * 将给定列表List转换成以逗号分隔的字符串
	 * @author Ritchieyan
	 * @param sources 列表
	 * @return 若未指定列表则返回空字符串，若返回null则表示格式化失败
	 * @date 2014年12月17日下午12:09:37
	 */
	public static String list2Str(List<String> sources) {
		return list2Str(sources, ",");
	}

	/**
	 * 将给定列表List转换成以指定分隔符分隔的字符串
	 * @author Ritchieyan
	 * @param sources 
	 * @param separator 分隔符，若未指定默认以逗号代替
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static String list2Str(List<String> sources, String separator) {
		try {
			return StringFormatter.format(sources, separator);
		} catch (Exception e) {
			Logger.getLogger(ListUtils.class).warn(e);
			return null;
		}
	}

	/**
	 * 将给定类型的对象列表转换成列表
	 * @author Ritchieyan
	 * @param array
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static <S> List<S> array2List(S... array) {
		List<S> strList = new LinkedList<S>();
		if (ArrayUtils.isNotEmpty(array)) {
			for (S string : array) {
				strList.add(string);
			}
		}
		return strList;
	}

	/**
	 * 字符串列表去重
	 * @author Ritchieyan
	 * @param sources
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static List<String> unique(List<String> sources) {
		if (CollectionUtils.isEmpty(sources)) {
			return sources;
		}
		List<String> targets = new ArrayList<String>();
		for (String source : sources) {
			if (StringUtils.isEmpty(source)) {
				continue;
			}
			if (targets.contains(source)) {
				continue;
			}
			targets.add(source);
		}
		return targets;
	}

	/**
	 * 将字符串列表转换成大写字符串列表，同时过滤掉null及空字符串
	 * @author Ritchieyan
	 * @param strList
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static List<String> toUpper(List<String> strList) {
		List<String> targets = new ArrayList<String>();
		for (String string : strList) {
			if (StringUtils.isNotBlank(string)) {
				targets.add(string.toUpperCase());
			}
		}
		return targets;
	}

	/**
	 * 将字符串列表转换成小写字符串列表，同时过滤掉null及空字符串
	 * @author Ritchieyan
	 * @param strList
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static List<String> toLower(List<String> strList) {
		List<String> targets = new ArrayList<String>();
		for (String string : strList) {
			if (StringUtils.isNotBlank(string)) {
				targets.add(string.toLowerCase());
			}
		}
		return targets;
	}

	/**
	 * 计算指定列表的长度
	 * @author Ritchieyan
	 * @param lists
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static int size(Collection<?> lists) {
		return lists == null ? 0 : lists.size();
	}

	/**
	 * 判定集合为空
	 * @author Ritchieyan
	 * @param entityList
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static boolean isEmpty(Collection<?> entityList) {
		return entityList == null || entityList.isEmpty();
	}

	/**
	 * 判定集合非空
	 * @author Ritchieyan
	 * @param entityList
	 * @return
	 * @date 2014年12月17日下午12:09:37
	 */
	public static boolean isNotEmpty(Collection<?> entityList) {
		return entityList != null && !entityList.isEmpty();
	}

	/**
	 * 列表排序,本排序方法是null值安全的
	 * @author Ritchieyan
	 * @param sources
	 * @param comparer
	 * @date 2014年12月17日下午12:09:37
	 */
	public static <T> void sortList(List<T> sources, Comparator<? super T> comparer) {
		if (isEmpty(sources) || comparer == null) {
			return;
		}
		Collections.sort(sources, comparer);
	}

	/**
	 * 列表排序
	 * @author Ritchieyan
	 * @param sources
	 * @date 2014年12月17日下午12:09:37
	 */
	public static <T extends Comparable<? super T>> void sortList(List<T> sources) {
		if (isEmpty(sources)) {
			return;
		}
		Collections.sort(sources);
	}

}
