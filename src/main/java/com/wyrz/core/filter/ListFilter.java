package com.wyrz.core.filter;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 集合类型数据过滤器顶级接口
 * @author Ritchieyan
 * @date 2014年12月17日上午10:55:16
 */
public interface ListFilter<S, T> extends Filter<S, T> {
	/**
	 * 过滤器顶级接口,该接口使用非全模式进行处理
	 * @author Ritchieyan
	 * @param sources
	 * @return
	 * @date 2014年12月17日上午10:55:16
	 */
	public List<T> filter(List<S> sources) throws ICoreException;

	/**
	 * 全模式过滤器顶级接口
	 * @author Ritchieyan
	 * @param sources
	 * @param fullMode true/false--是/否使用全模式
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:55:16
	 */
	public List<T> filter(List<S> sources, boolean fullMode) throws ICoreException;
}
