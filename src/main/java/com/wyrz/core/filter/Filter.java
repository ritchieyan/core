package com.wyrz.core.filter;

import com.wyrz.core.exception.ICoreException;

/**
 * 过滤器顶级接口
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:54:20
 */
public interface Filter<S, T> {
	/**
	 * 过滤器顶级接口
	 * @author Ritchieyan
	 * @param source
	 * @return 给定对象整个被过滤掉时将返回null值
	 * @date 2014年12月17日上午10:54:20
	 */
	public T filter(S source) throws ICoreException;
}
