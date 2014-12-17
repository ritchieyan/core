package com.wyrz.core.formatter;

import com.wyrz.core.exception.ICoreException;

/**
 * 格式化目标对象功能接口
 * 
 * @author Ritchieyan
 * @date 2014年12月17日下午12:03:13
 */
public interface Formatter<S, T> {
	/**
	 * 将指定源数据格式化成目标格式数据
	 * @Author Ritchieyan
	 * @param source 源数据
	 * @return  目标数据
	 * @throws ICoreException
	 * @Date 2014年12月17日下午12:03:13
	 */
	public T format(S source) throws ICoreException;
}
