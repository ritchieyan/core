package com.wyrz.core.iterator;

import com.wyrz.core.exception.ICoreException;

/**
 * 迭代器
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午9:56:58
 */
public interface Iterator<S, T> {
	/**
	 * 迭代处理数据
	 * 
	 * @author Ritchieyan
	 * @param source 源数据，若为null或空则直接返回null值
	 * @return 迭代处理后的数据
	 * @throws ICoreException
	 * @date 2014年12月16日下午9:57:16
	 */
	public T iterator(S source) throws ICoreException;
}
