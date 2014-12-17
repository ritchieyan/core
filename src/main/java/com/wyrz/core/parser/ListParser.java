package com.wyrz.core.parser;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 列表解析器
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:56:32
 */
public interface ListParser<S, T> extends Parser<S, T> {
	/**
	 * 列表数据解析,注意：解析后的列表与给定的源数据列表可能会长度不一致，
	 * 因为解析单个数据时可能会解析失败
	 * @Author Ritchieyan
	 * @param sources 源数据
	 * @return 解析后的数据列表
	 * @throws ICoreException
	 * @Date 2014年12月17日上午10:56:32
	 */
	public List<T> parser(List<S> sources) throws ICoreException;

	/**
	 * 解析数据列表
	 * @author Ritchieyan
	 * @param sources 需要被解析的数据列表
	 * @param fullMode 全模式
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:56:32
	 */
	public List<T> parser(List<S> sources, boolean fullMode) throws ICoreException;
}
