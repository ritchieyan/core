package com.wyrz.core.iterator;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 列表数据迭代处理逻辑接口
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午9:58:30
 */
public interface ListIterator<S, T> extends Iterator<List<S>, List<T>> {
	/**
	 * 迭代数据列表
	 * 
	 * @author Ritchieyan
	 * @param sources
	 * @param fullMode
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月16日下午9:59:47
	 */
	public List<T> iterator(List<S> sources, boolean fullMode) throws ICoreException;
}
