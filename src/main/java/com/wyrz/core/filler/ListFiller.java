package com.wyrz.core.filler;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 列表填充器
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:52:40
 */
public interface ListFiller<S, T> extends Filler<S, T> {
	/**
	 * 支持列表数据填充操作
	 * 
	 * @author Ritchieyan
	 * @param sources
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:52:56
	 */
	public List<T> fill(List<S> sources) throws ICoreException;

	/**
	 * 全模式的数据填充器
	 * @author Ritchieyan
	 * @param sources 数据列表，若为null或空则直接返回null
	 * @param fullMode true/false--全模式/通用模式
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:52:56
	 */
	public List<T> fill(List<S> sources, boolean fullMode) throws ICoreException;
}
