package com.wyrz.core.formatter;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 支持列表数据内容格式化功能
 * 
 * @author Ritchieyan
 * @date 2014年12月17日下午12:04:01
 */
public interface ListFormatter<S, T> extends Formatter<S, T> {
	/**
	 * 格式化列表
	 * @Author Ritchieyan
	 * @param sources 数据列表，若给定列表为null或空则返回null值
	 * @return 格式化后的数据列表
	 * @throws ICoreException
	 * @Date 2014年12月17日下午12:04:01
	 */
	public List<T> format(List<S> sources) throws ICoreException;

	/**
	 * 以全模式进行格式化
	 * @author Ritchieyan
	 * @param sources 数据列表
	 * @param fullMode 是否为全模式
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日下午12:04:01
	 */
	public List<T> format(List<S> sources, boolean fullMode) throws ICoreException;
}
