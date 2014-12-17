package com.wyrz.core.builder;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 列表数据构建器
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:33:23
 */
public interface ListBuilder<S, T> extends Builder<S, T> {
	/**
	 * 列表数据构建
	 * 
	 * @author Ritchieyan
	 * @param sources
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:33:44
	 */
	public List<T> build(List<S> sources) throws ICoreException;

	/**
	 * 列表数据构建
	 * @Author Ritchieyan
	 * @param sources
	 * @param fullMode 是/否使用全模式
	 * @return
	 * @throws ICoreException
	 * @Date 2014年12月17日上午10:33:44
	 */
	public List<T> build(List<S> sources, boolean fullMode) throws ICoreException;
}
